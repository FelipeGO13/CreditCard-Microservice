package br.com.itau.customer.service;


import br.com.itau.customer.exception.CustomerException;
import br.com.itau.customer.models.Customer;
import br.com.itau.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getById(Long id) {
		Optional<Customer> cliente = customerRepository.findById(id);

		if (!cliente.isPresent()) {
			throw new CustomerException("Cliente", "Cliente não encontrado");
		}

		return cliente.get();
	}

}
