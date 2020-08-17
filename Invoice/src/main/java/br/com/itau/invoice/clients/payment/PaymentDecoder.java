package br.com.itau.invoice.clients.payment;

import feign.Response;
import feign.codec.ErrorDecoder;

public class PaymentDecoder implements ErrorDecoder {

    ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
       if(response.status() == 404){
          return new PaymentNotFoundException("Pagamento", "Pagamentos não encontrados");
       }
       return errorDecoder.decode(s, response);
    }
}
