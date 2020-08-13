package br.com.itau.payment.repository;


import br.com.itau.payment.model.Payment;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface PaymentRepository extends CrudRepository<Payment, Long>{
	Iterable<Payment> findByCreditCardId(Long creditCardId);

	@Transactional
	Iterable<Payment> deleteByCreditCardId(Long creditCardId);
}
