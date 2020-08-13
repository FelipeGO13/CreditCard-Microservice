package br.com.itau.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class CreatePaymentRequest {

	@JsonProperty("cartao_id")
	private Long creditCardId;

	@JsonProperty("descricao")
	private String description;

	@DecimalMin(value = "0.01", inclusive = true)
	@JsonProperty("valor")
	private BigDecimal value;

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
