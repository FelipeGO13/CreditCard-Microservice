package br.com.itau.fatura.clients.payment;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PaymentConfiguration {

    @Bean
    public ErrorDecoder getPaymentDecoder(){
        return new PaymentDecoder();
    }


}
