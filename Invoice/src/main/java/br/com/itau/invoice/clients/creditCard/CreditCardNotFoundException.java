package br.com.itau.invoice.clients.creditCard;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreditCardNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String atributo;

    public String getAtributo() {
        return atributo;
    }

    public CreditCardNotFoundException(String atributo, String message) {
        super(message);
        this.atributo = atributo;
    }

}
