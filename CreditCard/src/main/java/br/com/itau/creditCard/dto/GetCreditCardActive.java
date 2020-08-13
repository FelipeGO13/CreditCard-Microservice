package br.com.itau.creditCard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCreditCardActive {

    private Long id;

    @JsonProperty("ativo")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
