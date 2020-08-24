package br.com.itau.invoice.clients.payment;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class PaymentConfiguration {

    @Autowired
    private OAuth2ClientContext clientContext;

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(clientContext, clientCredentialsResourceDetails);
    }

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
