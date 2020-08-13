package br.com.itau.payment.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CREDITCARD")
public interface CreditCardClient {

    @GetMapping("/cartao/id/{id}")
    CreditCard getById(@PathVariable Long id);

    @GetMapping("/{id}/ativo")
    CreditCard isActive(@PathVariable Long id);

}
