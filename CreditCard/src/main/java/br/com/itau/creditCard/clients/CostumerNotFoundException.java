package br.com.itau.creditCard.clients;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CostumerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String atributo;

    public String getAtributo() {
        return atributo;
    }

    public CostumerNotFoundException(String atributo, String message) {
        super(message);
        this.atributo = atributo;
    }


}
