package br.com.itau.customer.repository;


import br.com.itau.customer.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
