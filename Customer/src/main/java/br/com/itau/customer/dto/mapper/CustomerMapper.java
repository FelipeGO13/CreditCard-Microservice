package br.com.itau.customer.dto.mapper;

import br.com.itau.customer.dto.CreateCustomerRequest;
import br.com.itau.customer.dto.CustomerResponse;
import br.com.itau.customer.models.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CreateCustomerRequest createCustomerRequest){
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());

        return customer;
    }

    public CustomerResponse toCreateCustomerResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());

        return customerResponse;
    }


}
