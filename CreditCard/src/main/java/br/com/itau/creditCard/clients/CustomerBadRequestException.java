package br.com.itau.creditCard.clients;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "Serviço de clientes não disponível")
public class CustomerBadRequestException extends RuntimeException{


}
