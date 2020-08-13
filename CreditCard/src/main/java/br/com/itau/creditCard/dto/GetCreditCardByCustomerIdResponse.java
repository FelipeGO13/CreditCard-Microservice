package br.com.itau.creditCard.dto;

import br.com.itau.creditCard.dto.GetCreditCardResponse;

public class GetCreditCardByCustomerIdResponse {

    private Iterable<GetCreditCardResponse> creditCardList;

    public Iterable<GetCreditCardResponse> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(Iterable<GetCreditCardResponse> creditCardList) {
        this.creditCardList = creditCardList;
    }
}
