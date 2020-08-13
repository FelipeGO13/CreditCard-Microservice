package br.com.itau.creditCard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateCreditCardRequest {

	@NotNull
	@NotEmpty
	@JsonProperty("numero")
	private String number;

	@NotNull
	@JsonProperty("clienteId")
	private Long clientId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
