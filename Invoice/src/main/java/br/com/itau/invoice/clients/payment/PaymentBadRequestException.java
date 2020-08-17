package br.com.itau.invoice.clients.payment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Serviço de pagamentos indisponível")
public class PaymentBadRequestException extends RuntimeException {
}
