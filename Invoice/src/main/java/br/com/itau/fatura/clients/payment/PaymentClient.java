package br.com.itau.fatura.clients.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PAYMENT", configuration = PaymentConfiguration.class)
public interface PaymentClient {

    @GetMapping("/pagamentos/{id_cartao}")
    Iterable<Payment> getByCreditCardId(@PathVariable(name = "id_cartao") Long creditCardId);

    @DeleteMapping("/pagamentos/{id_cartao}")
    Iterable<Payment> deletePayments(@PathVariable(name = "id_cartao") Long creditCardId);
}
