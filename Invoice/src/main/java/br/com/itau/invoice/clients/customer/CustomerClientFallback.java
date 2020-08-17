package br.com.itau.invoice.clients.customer;

public class CustomerClientFallback implements CustomerClient {

    @Override
    public Customer getById(Long id) {
        throw new CustomerBadRequestException();
    }
}
