package br.com.itau.fatura.clients.creditCard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CREDITCARD", configuration = CreditCardConfiguration.class)
public interface CreditCardClient {

    @GetMapping("/cartao/cliente/{cliente_id}/{cartao_id}")
    CreditCard getByCustomerIdAndCreditCardId(@PathVariable("cliente_id") Long customerId, @PathVariable("cartao_id") Long creditCardId);

    @PatchMapping("/cartao/{id}/desativar")
    CreditCard expireCreditCard(@PathVariable Long id);
}
