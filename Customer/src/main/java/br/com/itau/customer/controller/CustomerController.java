package br.com.itau.customer.controller;

import br.com.itau.customer.dto.CreateCustomerRequest;
import br.com.itau.customer.dto.CustomerResponse;
import br.com.itau.customer.dto.mapper.CustomerMapper;
import br.com.itau.customer.models.Customer;
import br.com.itau.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerMapper customerMapper;
	
	@PostMapping(produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
		Customer customer = customerMapper.toCustomer(createCustomerRequest);

		customer = customerService.create(customer);

		return customerMapper.toCreateCustomerResponse(customer);
	}
	
	@GetMapping("/{id}")
	public CustomerResponse getById(@PathVariable Long id){
		Customer customer = customerService.getById(id);
		return customerMapper.toCreateCustomerResponse(customer);
	}
	
}
