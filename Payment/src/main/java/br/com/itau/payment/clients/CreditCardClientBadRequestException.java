package br.com.itau.payment.clients;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Serviço de cartão de crédito não encontrado")
public class CreditCardClientBadRequestException extends RuntimeException {
}
