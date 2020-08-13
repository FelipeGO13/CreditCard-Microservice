package br.com.itau.payment.clients;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CreditCardConfiguration {

    @Bean
    public ErrorDecoder getCrediClientDecoder(){
        return new CreditCardDecoder();
    }

}
