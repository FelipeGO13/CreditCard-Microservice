package br.com.itau.fatura.clients.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String atributo;

    public String getAtributo() {
        return atributo;
    }

    public CustomerNotFoundException(String atributo, String message) {
        super(message);
        this.atributo = atributo;
    }


}
