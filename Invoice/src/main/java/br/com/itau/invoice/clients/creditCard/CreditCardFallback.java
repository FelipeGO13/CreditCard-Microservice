package br.com.itau.invoice.clients.creditCard;

public class CreditCardFallback implements CreditCardClient {

    @Override
    public CreditCard getByCustomerIdAndCreditCardId(Long customerId, Long creditCardId) {
       throw new CreditCardClientBadRequestException();
    }

    @Override
    public CreditCard expireCreditCard(Long id) {
        throw new CreditCardClientBadRequestException();
    }
}
