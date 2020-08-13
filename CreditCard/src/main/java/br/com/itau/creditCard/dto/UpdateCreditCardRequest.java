package br.com.itau.creditCard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCreditCardRequest {

    @JsonProperty("ativo")
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
