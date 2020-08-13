package br.com.itau.creditCard.controller;



import br.com.itau.creditCard.dto.*;
import br.com.itau.creditCard.dto.mapper.CreditCardMapper;
import br.com.itau.creditCard.models.CreditCard;
import br.com.itau.creditCard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private CreditCardMapper creditCardMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateCreditCardResponse create(@Valid @RequestBody CreateCreditCardRequest createCreditCardRequest){
		CreditCard creditCard = creditCardService.create(creditCardMapper.toCreditCard(createCreditCardRequest));

		return creditCardMapper.toCreateCreditCardResponse(creditCard);
	}

	@PatchMapping("/{numero}")
	public CreateCreditCardResponse updateCard(@PathVariable("numero") String number, @Valid @RequestBody UpdateCreditCardRequest updateCreditCardRequest) {
		CreditCard updatedCreditCard = creditCardService.update(number, creditCardMapper.toCreditCard(updateCreditCardRequest));

		return creditCardMapper.toCreateCreditCardResponse(updatedCreditCard);

	}

	@GetMapping("/{numero}")
	public GetCreditCardResponse getByNumber(@PathVariable("numero") String number) {
		CreditCard creditCard = creditCardService.getByNumber(number);

		return creditCardMapper.toGetCreditCardResponse(creditCard);
	}

	@GetMapping("/id/{id}")
	public CreditCard getById(@PathVariable Long id){
		return creditCardService.getById(id);
	}

	@GetMapping("cliente/{clienteId}")
	public GetCreditCardByCustomerIdResponse getByCustomerId(@PathVariable("clienteId") Long customerId){
		return creditCardMapper.toGetCreditCardByCustomerIdResponse(creditCardService.getByCustomerId(customerId));
	}


}
