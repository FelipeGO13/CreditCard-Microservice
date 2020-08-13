package br.com.itau.creditCard.dto.mapper;


import br.com.itau.creditCard.dto.*;
import br.com.itau.creditCard.models.CreditCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditCardMapper {

	public CreditCard toCreditCard(CreateCreditCardRequest creditCardRequest) {

		CreditCard creditCard = new CreditCard();
		creditCard.setNumber(creditCardRequest.getNumber());
		creditCard.setCustomerId(creditCardRequest.getClientId());
		creditCard.setActive(false);

		return creditCard;

	}

	public CreditCard toCreditCard(UpdateCreditCardRequest updateCreditCardRequest) {

		CreditCard creditCard = new CreditCard();
		creditCard.setActive(updateCreditCardRequest.isActive());

		return creditCard;

	}

	public CreateCreditCardResponse toCreateCreditCardResponse(CreditCard creditCard){
		CreateCreditCardResponse createCreditCardResponse = new CreateCreditCardResponse();

		createCreditCardResponse.setId(creditCard.getId());
		createCreditCardResponse.setNumber(creditCard.getNumber());
		createCreditCardResponse.setCustomerId(creditCard.getCustomerId());
		createCreditCardResponse.setActive(creditCard.isActive());

		return createCreditCardResponse;
	}

	public GetCreditCardResponse toGetCreditCardResponse(CreditCard creditCard) {

		GetCreditCardResponse getCreditCardResponse = new GetCreditCardResponse();

		getCreditCardResponse.setId(creditCard.getId());
		getCreditCardResponse.setNumber(creditCard.getNumber());
		getCreditCardResponse.setCustomerId(creditCard.getCustomerId());

		return getCreditCardResponse;

	}

	public GetCreditCardByCustomerIdResponse toGetCreditCardByCustomerIdResponse(Iterable<CreditCard> creditCards){
		GetCreditCardByCustomerIdResponse getCreditCardByCustomerIdResponse = new GetCreditCardByCustomerIdResponse();
		List<GetCreditCardResponse> getCreditCardResponseList = new ArrayList<>();

		for(CreditCard c: creditCards){
			getCreditCardResponseList.add(toGetCreditCardResponse(c));
		}

		getCreditCardByCustomerIdResponse.setCreditCardList(getCreditCardResponseList);

		return getCreditCardByCustomerIdResponse;
	}


}
