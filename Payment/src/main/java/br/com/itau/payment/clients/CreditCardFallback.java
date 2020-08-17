package br.com.itau.payment.clients;

public class CreditCardFallback implements CreditCardClient {

    @Override
    public CreditCard getById(Long id) {
        throw new CreditCardClientBadRequestException();
    }

    @Override
    public CreditCard isActive(Long id) {
        throw new CreditCardClientBadRequestException();
    }
}
