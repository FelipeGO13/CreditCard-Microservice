package br.com.itau.creditCard.clients;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CostumerClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404){
            return new CostumerNotFoundException("Cliente", "Cliente não encontrado");
        }

        return errorDecoder.decode(s, response);
    }
}
