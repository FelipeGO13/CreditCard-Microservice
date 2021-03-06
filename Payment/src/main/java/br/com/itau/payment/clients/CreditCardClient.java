package br.com.itau.payment.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CREDITCARD", configuration = CreditCardConfiguration.class)
public interface CreditCardClient {

    @GetMapping("/cartao/id/{id}")
    CreditCard getById(@PathVariable Long id);

    @GetMapping("/cartao/{id}/ativo")
    CreditCard isActive(@PathVariable Long id);

}
