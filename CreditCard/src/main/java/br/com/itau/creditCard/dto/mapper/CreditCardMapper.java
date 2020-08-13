package br.com.itau.creditCard.dto.mapper;


import br.com.itau.creditCard.dto.*;
import br.com.itau.creditCard.models.CreditCard;
import org.springframework.stereotype.Component;

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

	public GetCreditCardActive toGetCreditCardActive(CreditCard creditCard){
		GetCreditCardActive getCreditCardActive = new GetCreditCardActive();

		getCreditCardActive.setId(creditCard.getId());
		getCreditCardActive.setActive(creditCard.isActive());

		return  getCreditCardActive;
	}

}
