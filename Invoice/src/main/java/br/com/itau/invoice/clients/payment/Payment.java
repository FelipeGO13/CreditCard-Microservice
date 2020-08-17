package br.com.itau.invoice.clients.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Payment {

    private Long id;

    @JsonProperty("cartao_id")
    private Long creditCardId;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor")
     private BigDecimal value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
