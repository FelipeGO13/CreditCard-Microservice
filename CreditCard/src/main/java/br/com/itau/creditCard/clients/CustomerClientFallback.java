package br.com.itau.creditCard.clients;

public class CustomerClientFallback implements CustomerClient {


    @Override
    public Customer getById(Long id) {
        throw new CustomerBadRequestException();
    }
}
