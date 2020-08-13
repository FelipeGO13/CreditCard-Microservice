package br.com.itau.payment.controller;


import br.com.itau.payment.dto.CreatePaymentRequest;
import br.com.itau.payment.dto.CreatePaymentResponse;
import br.com.itau.payment.dto.mapper.PaymentMapper;
import br.com.itau.payment.model.Payment;
import br.com.itau.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMapper paymentMapper;

    @PostMapping("/pagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePaymentResponse create(@Valid @RequestBody CreatePaymentRequest createPaymentRequest) {

        Payment payment = paymentService.create(paymentMapper.toPayment(createPaymentRequest));

        return paymentMapper.toCreatePaymentResponse(payment);
    }

    @GetMapping("/pagamentos/{id_cartao}")
    public Iterable<CreatePaymentResponse> getByCreditCardId(@PathVariable(name = "id_cartao") Long creditCardId) {

        return paymentMapper.toPaymentList(paymentService.getByCreditCardId(creditCardId));
    }

}
