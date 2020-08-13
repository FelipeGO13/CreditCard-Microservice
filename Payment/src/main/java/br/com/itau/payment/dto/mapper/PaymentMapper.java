package br.com.itau.payment.dto.mapper;


import br.com.itau.payment.dto.CreatePaymentRequest;
import br.com.itau.payment.dto.CreatePaymentResponse;
import br.com.itau.payment.model.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapper {

	public Payment toPayment(CreatePaymentRequest createPaymentRequest) {
		Payment payment = new Payment();

		payment.setCreditCardId(createPaymentRequest.getCreditCardId());
		payment.setDescription(createPaymentRequest.getDescription());
		payment.setValue(createPaymentRequest.getValue());
		
		return payment;
	}

	public CreatePaymentResponse toCreatePaymentResponse(Payment payment){
		CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();

		createPaymentResponse.setId(payment.getId());
		createPaymentResponse.setCreditCardId(payment.getCreditCardId());
		createPaymentResponse.setDescription(payment.getDescription());
		createPaymentResponse.setValue(payment.getValue());

		return createPaymentResponse;
	}

	
	public Iterable<CreatePaymentResponse> toPaymentList(Iterable<Payment> payments) {
		List<CreatePaymentResponse> createPaymentResponseList = new ArrayList<>();

		for(Payment p : payments) {
			createPaymentResponseList.add(toCreatePaymentResponse(p));
		}

		return createPaymentResponseList;
	}
}
