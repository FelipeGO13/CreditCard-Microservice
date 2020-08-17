package br.com.itau.invoice.service;

import br.com.itau.invoice.clients.customer.Customer;
import br.com.itau.invoice.clients.customer.CustomerClient;
import br.com.itau.invoice.clients.creditCard.CreditCard;
import br.com.itau.invoice.clients.creditCard.CreditCardClient;
import br.com.itau.invoice.clients.payment.Payment;
import br.com.itau.invoice.clients.payment.PaymentClient;
import br.com.itau.invoice.model.Invoice;
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

    @Autowired
    private CustomerClient customerClient;

    public Invoice getByCustomerIdAndCreditCardId(Long customerId, Long creditCardId){
        Customer customer = customerClient.getById(customerId);

        CreditCard creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customer.getId(), creditCardId);

        Iterable<Payment> paymentList = paymentClient.getByCreditCardId(creditCard.getId());

        Invoice invoice = new Invoice();

        invoice.setPayments(paymentList);

        return invoice;
    }

    public Invoice payInvoice(Long customerId, Long creditCardId){
        Customer customer = customerClient.getById(customerId);

        CreditCard creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customer.getId(), creditCardId);

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
        Customer customer = customerClient.getById(customerId);

        CreditCard creditCard = creditCardClient.getByCustomerIdAndCreditCardId(customer.getId(), creditCardId);

        creditCardClient.expireCreditCard(creditCard.getId());

        return "ok";
    }


}
