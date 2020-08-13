package br.com.itau.fatura.service;

import br.com.itau.fatura.clients.CreditCard;
import br.com.itau.fatura.clients.CreditCardClient;
import br.com.itau.fatura.clients.Payment;
import br.com.itau.fatura.clients.PaymentClient;
import br.com.itau.fatura.model.Invoice;
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
        CreditCard creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customerId, creditCardId);

        Iterable<Payment> paymentList = paymentClient.getByCreditCardId(creditCard.getId());

        Invoice invoice = new Invoice();

        invoice.setPayments(paymentList);

        return invoice;
    }

    public Invoice payInvoice(Long customerId, Long creditCardId){
        CreditCard creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customerId, creditCardId);

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
        CreditCard creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customerId, creditCardId);

        creditCardClient.expireCreditCard(creditCard.getId());

        return "ok";
    }


}
