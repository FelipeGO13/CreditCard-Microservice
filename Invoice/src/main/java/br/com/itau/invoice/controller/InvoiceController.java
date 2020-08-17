package br.com.itau.invoice.controller;

import br.com.itau.invoice.dto.CreatePaymentResponse;
import br.com.itau.invoice.dto.ExpireCardResponse;
import br.com.itau.invoice.dto.GetInvoiceResponse;
import br.com.itau.invoice.dto.mapper.InvoiceMapper;
import br.com.itau.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fatura")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @GetMapping("/{cliente-id}/{cartao-id}")
    public Iterable<GetInvoiceResponse> getByCustomerIdAndCreditCardId(@PathVariable(name = "cliente-id") Long customerId, @PathVariable(name = "cartao-id") Long creditCardId){

        return invoiceMapper.toGetInvoiceResponseList(invoiceService.getByCustomerIdAndCreditCardId(customerId, creditCardId));
    }

    @PostMapping("/{cliente-id}/{cartao-id}/pagar")
    public CreatePaymentResponse payInvoice(@PathVariable(name = "cliente-id") Long customerId, @PathVariable(name = "cartao-id") Long creditCardId){

        return invoiceMapper.toCreatePaymentResponse(invoiceService.payInvoice(customerId, creditCardId));
    }

    @PostMapping("/{cliente-id}/{cartao-id}/expirar")
    public ExpireCardResponse expireCreditCard(@PathVariable(name = "cliente-id") Long customerId, @PathVariable(name = "cartao-id") Long creditCardId){
        return invoiceMapper.toExpireCardResponse(invoiceService.expireCreditCard(customerId, creditCardId));
    }

}
