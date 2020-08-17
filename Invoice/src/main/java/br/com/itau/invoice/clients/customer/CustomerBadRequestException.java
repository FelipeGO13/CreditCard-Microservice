package br.com.itau.invoice.clients.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "Serviço de clientes indisponível")
public class CustomerBadRequestException extends RuntimeException{


}
