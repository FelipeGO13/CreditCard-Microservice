package br.com.itau.fatura.service;

import br.com.itau.fatura.clients.creditCard.CreditCard;
import br.com.itau.fatura.clients.creditCard.CreditCardClient;
import br.com.itau.fatura.clients.payment.Payment;
import br.com.itau.fatura.clients.payment.PaymentClient;
import br.com.itau.fatura.exception.InvoiceException;
import br.com.itau.fatura.model.Invoice;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class InvoiceService {

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private CreditCardClient creditCardClient;


    public Invoice getByCustomerIdAndCreditCardId(Long customerId, Long creditCardId){
        CreditCard creditCard;

        try{
            creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customerId, creditCardId);
        } catch (FeignException.FeignClientException.NotFound e) {
            throw new InvoiceException("Fatura", "Não foi possível encontrar fatura: cartão não encontrado");
        }

        Iterable<Payment> paymentList = paymentClient.getByCreditCardId(creditCard.getId());

        Invoice invoice = new Invoice();

        invoice.setPayments(paymentList);

        return invoice;
    }

    public Invoice payInvoice(Long customerId, Long creditCardId){
        CreditCard creditCard;

        try{
            creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customerId, creditCardId);
        } catch (FeignException.FeignClientException.NotFound e) {
            throw new InvoiceException("Fatura", "Não foi possível encontrar fatura: cartão não encontrado");
        }

        Iterable<Payment> paymentList = paymentClient.deletePayments(creditCard.getId());

        Invoice invoice = new Invoice();

        BigDecimal paidValue = BigDecimal.ZERO;

        for(Payment p : paymentList) {
            paidValue = paidValue.add(p.getValue());
        }

        invoice.setCreditCardId(creditCard.getId());
        invoice.setPaidValue(paidValue);
        invoice.setPaymentDate(LocalDate.now());

        return invoice;
    }

    public String expireCreditCard(Long customerId, Long creditCardId){
        CreditCard creditCard;

        try{
            creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customerId, creditCardId);
        } catch (FeignException.FeignClientException.NotFound e) {
            throw new InvoiceException("Fatura", "Não foi possível encontrar fatura: cartão não encontrado");
        }

        creditCardClient.expireCreditCard(creditCard.getId());

        return "ok";
    }


}
