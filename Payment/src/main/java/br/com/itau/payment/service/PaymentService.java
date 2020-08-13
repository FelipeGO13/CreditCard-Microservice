package br.com.itau.payment.service;


import br.com.itau.payment.clients.CreditCard;
import br.com.itau.payment.clients.CreditCardClient;
import br.com.itau.payment.model.Payment;
import br.com.itau.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CreditCardClient creditCardClient;
	
	public Payment create(Payment payment) {
		
		CreditCard creditCard = creditCardClient.getById(payment.getCreditCardId());
		
		Payment createdPayment = new Payment();

		createdPayment.setCreditCardId(payment.getCreditCardId());
		createdPayment.setDescription(payment.getDescription());
		createdPayment.setValue(payment.getValue());
		
		return paymentRepository.save(createdPayment);
	}
	
	public Iterable<Payment> getByCreditCardId(Long creditCardId){
		CreditCard creditCard = creditCardClient.getById(creditCardId);
		
		return paymentRepository.findByCreditCardId(creditCard.getId());
		
	}
	
}
