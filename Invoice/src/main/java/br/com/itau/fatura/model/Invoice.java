package br.com.itau.fatura.model;


import br.com.itau.fatura.clients.payment.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {

    private Iterable<Payment> payments;

    private Long creditCardId;

    private BigDecimal paidValue;

    private LocalDate paymentDate;

    public Iterable<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Iterable<Payment> payments) {
        this.payments = payments;
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public BigDecimal getPaidValue() {
        return paidValue;
    }

    public void setPaidValue(BigDecimal paidValue) {
        this.paidValue = paidValue;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
