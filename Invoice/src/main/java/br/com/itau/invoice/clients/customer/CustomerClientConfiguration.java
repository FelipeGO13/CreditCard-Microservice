package br.com.itau.invoice.clients.customer;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

    @Bean
    public ErrorDecoder getCostumerClientDecode(){
        return new CustomerClientDecoder();
    }

}
