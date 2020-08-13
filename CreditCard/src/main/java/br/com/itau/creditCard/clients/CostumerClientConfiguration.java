package br.com.itau.creditCard.clients;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CostumerClientConfiguration {

    @Bean
    public ErrorDecoder getCostumerClientDecode(){
        return new CostumerClientDecoder();
    }

}
