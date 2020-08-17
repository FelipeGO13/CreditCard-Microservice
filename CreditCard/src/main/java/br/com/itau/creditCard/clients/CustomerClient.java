package br.com.itau.creditCard.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {

    @GetMapping("/cliente/{id}")
    Customer getById(@PathVariable Long id);
    

}
