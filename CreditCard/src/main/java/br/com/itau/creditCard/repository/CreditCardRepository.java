package br.com.itau.creditCard.repository;

import br.com.itau.creditCard.models.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long>{
	Optional<CreditCard> findByNumber(String number);
	Iterable<CreditCard> findByCustomerId(Long customerId);
}
