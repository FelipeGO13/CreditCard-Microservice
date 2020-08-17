package br.com.itau.invoice.clients.creditCard;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorator;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CreditCardConfiguration {

    @Bean
    public ErrorDecoder getCrediClientDecoder(){
        return new CreditCardDecoder();
    }

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CreditCardFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }


}
