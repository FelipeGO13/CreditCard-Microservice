package br.com.itau.payment;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Bean
    public IRule getRibbonRule(){
        return new WeightedResponseTimeRule();
    }

}
