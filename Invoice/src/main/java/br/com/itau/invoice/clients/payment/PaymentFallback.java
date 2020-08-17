package br.com.itau.invoice.clients.payment;

public class PaymentFallback implements PaymentClient {
    @Override
    public Iterable<Payment> getByCreditCardId(Long creditCardId) {
        throw new PaymentBadRequestException();
    }

    @Override
    public Iterable<Payment> deletePayments(Long creditCardId) {
        throw new PaymentBadRequestException();
    }
}
