package br.com.itau.payment.service;


import br.com.itau.payment.clients.CreditCard;
import br.com.itau.payment.clients.CreditCardClient;
import br.com.itau.payment.exception.PaymentException;
import br.com.itau.payment.model.Payment;
import br.com.itau.payment.repository.PaymentRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CreditCardClient creditCardClient;
	
	public Payment create(Payment payment) {
		CreditCard creditCard = creditCardClient.getById(payment.getCreditCardId());

		if(!creditCard.isActive()){
			throw new PaymentException("Pagamento", "Não foi possível criar o pagamento: cartão inativo");
		}
		
		Payment createdPayment = new Payment();

		createdPayment.setCreditCardId(payment.getCreditCardId());
		createdPayment.setDescription(payment.getDescription());
		createdPayment.setValue(payment.getValue());
		
		return paymentRepository.save(createdPayment);
	}
	
	public Iterable<Payment> getByCreditCardId(Long creditCardId){
		CreditCard creditCard = creditCardClient.getById(creditCardId);

		Iterable<Payment> payments = paymentRepository.findByCreditCardId(creditCard.getId());

		if(StreamSupport.stream(payments.spliterator(), false).count() == 0){
			throw new PaymentException("Pagamento", "Não existem pagamentos registrados");
		}

		return payments;
	}

	public Iterable<Payment> deleteByCreditCardId(Long creditCardId){
		CreditCard creditCard = creditCardClient.getById(creditCardId);

		Iterable<Payment> payments = paymentRepository.deleteByCreditCardId(creditCard.getId());

		if(StreamSupport.stream(payments.spliterator(), false).count() == 0){
			throw new PaymentException("Pagamento", "Não existem pagamentos registrados");
		}

		return payments;
	}

}
