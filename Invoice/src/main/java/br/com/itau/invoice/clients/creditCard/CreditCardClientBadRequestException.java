package br.com.itau.invoice.clients.creditCard;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Serviço de cartão de crédito indisponível")
public class CreditCardClientBadRequestException extends RuntimeException {
}
