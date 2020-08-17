package br.com.itau.invoice.dto.mapper;

import br.com.itau.invoice.clients.payment.Payment;
import br.com.itau.invoice.dto.ExpireCardResponse;
import br.com.itau.invoice.dto.GetInvoiceResponse;
import br.com.itau.invoice.dto.CreatePaymentResponse;
import br.com.itau.invoice.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceMapper {

    public GetInvoiceResponse toGetInvoiceResponse(Payment payment){
        GetInvoiceResponse getInvoiceResponse = new GetInvoiceResponse();

        getInvoiceResponse.setPaymentId(payment.getId());
        getInvoiceResponse.setCreditCardId(payment.getCreditCardId());
        getInvoiceResponse.setPaymentDescription(payment.getDescription());
        getInvoiceResponse.setValue(payment.getValue());

        return getInvoiceResponse;
    }

    public Iterable<GetInvoiceResponse> toGetInvoiceResponseList(Invoice invoice){
        List<GetInvoiceResponse> getInvoiceResponse = new ArrayList<>();

        for(Payment p: invoice.getPayments()){
            getInvoiceResponse.add(toGetInvoiceResponse(p));
        }

        return getInvoiceResponse;
    }

    public CreatePaymentResponse toCreatePaymentResponse(Invoice invoice){
        CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();

        createPaymentResponse.setCreditCardId(invoice.getCreditCardId());
        createPaymentResponse.setPaidValue(invoice.getPaidValue());
        createPaymentResponse.setPaymentDate(invoice.getPaymentDate());

        return createPaymentResponse;
    }

    public ExpireCardResponse toExpireCardResponse(String status){
        ExpireCardResponse expireCardResponse = new ExpireCardResponse();

        expireCardResponse.setStatus(status);

        return expireCardResponse;
    }



}
