package br.com.itau.invoice.clients.creditCard;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CreditCardDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404){
            throw new CreditCardNotFoundException("Cartao", "Cartão não encontrado");
        }
        return null;
    }
}
