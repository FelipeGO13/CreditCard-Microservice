package br.com.itau.invoice.clients.payment;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class PaymentConfiguration {

    @Bean
    public ErrorDecoder getPaymentDecoder(){
        return new PaymentDecoder();
    }

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new PaymentFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }

}
