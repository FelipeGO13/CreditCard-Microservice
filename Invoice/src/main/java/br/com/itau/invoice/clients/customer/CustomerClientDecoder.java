package br.com.itau.invoice.clients.customer;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404){
            return new CustomerNotFoundException("Cliente", "Cliente não encontrado");
        }

        return errorDecoder.decode(s, response);
    }
}
