package br.com.itau.creditCard.service;


import br.com.itau.creditCard.clients.Customer;
import br.com.itau.creditCard.clients.CustomerClient;
import br.com.itau.creditCard.exception.CreditCardException;
import br.com.itau.creditCard.models.CreditCard;
import br.com.itau.creditCard.repository.CreditCardRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Autowired
	private CustomerClient customerClient;
	
	public CreditCard create(CreditCard creditCard) {
		Customer customer;

		try {
			customer = customerClient.getById(creditCard.getCustomerId());
		} catch(FeignException.FeignClientException.NotFound e){
			throw new CreditCardException("Cartão", "Não foi possível criar o cartão: cliente não encontrado");
		}

		CreditCard createdCreditCard = new CreditCard();

		createdCreditCard.setCustomerId(customer.getId());
		createdCreditCard.setNumber(creditCard.getNumber());
		createdCreditCard.setActive(false);
		
		return creditCardRepository.save(creditCard);
	}
	
	public CreditCard getByNumber(String number){
		
		Optional<CreditCard> creditCard = creditCardRepository.findByNumber(number);
		
		if(!creditCard.isPresent()) {
			throw new CreditCardException("Cartão", "Cartão não encontrado");
		}
		
		return creditCard.get();
	}

	public CreditCard getByCustomerIdAndCreditCardId(Long customerId, Long creditCardId){

		Customer customer;

		try {
			customer = customerClient.getById(customerId);
		} catch(FeignException.FeignClientException.NotFound e){
			throw new CreditCardException("Cartão", "Não foi possível encontrar o cartão: cliente não encontrado");
		}

		Optional<CreditCard> selectedCreditCard = creditCardRepository.findByCustomerIdAndId(customer.getId(), creditCardId);

		if(!selectedCreditCard.isPresent()) {
			throw new CreditCardException("Cartão", "Cartão não encontrado");
		}

		return selectedCreditCard.get();
	}

	public CreditCard update(String number, CreditCard creditCard) {
		
		Optional<CreditCard> selectedCreditCard = creditCardRepository.findByNumber(number);
		
		if(!selectedCreditCard.isPresent()) {
			throw new CreditCardException("Cartão", "Cartão não encontrado");
		}

		selectedCreditCard.get().setActive(creditCard.isActive());
		
		return creditCardRepository.save(selectedCreditCard.get());
	}

	public CreditCard getById(Long id){
		Optional<CreditCard> creditCard = creditCardRepository.findById(id);

		if(!creditCard.isPresent()) {
			throw new CreditCardException("Cartão", "Cartão não encontrado");
		}

		return creditCard.get();
	}


	public CreditCard isActive(Long id){
		Optional<CreditCard> selectedCreditCard = creditCardRepository.findById(id);

		if(!selectedCreditCard.isPresent()) {
			throw new CreditCardException("Cartão", "Cartão não encontrado");
		}

		CreditCard creditCard = new CreditCard();

		creditCard.setId(selectedCreditCard.get().getId());
		creditCard.setActive(selectedCreditCard.get().isActive());

		return creditCard;
	}

	public CreditCard expire(Long id) {

		Optional<CreditCard> creditCard = creditCardRepository.findById(id);

		if(!creditCard.isPresent()) {
			throw new CreditCardException("Cartão", "Cartão não encontrado");
		}

		creditCard.get().setActive(false);

		return creditCardRepository.save(creditCard.get());
	}

}
