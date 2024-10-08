package by.salary.useragreementservice.controller;

import by.salary.useragreementservice.model.PaymentRequestDTO;
import by.salary.useragreementservice.model.PaymentResponseDTO;
import by.salary.useragreementservice.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "Get all payments")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @Operation(summary = "Get payment by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseDTO getPaymentById(Long id) {
        return paymentService.getPaymentById(id);
    }

    @Operation(summary = "Create payment")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.createPayment(paymentRequestDTO);
    }

    @Operation(summary = "Delete payment by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseDTO deletePaymentById(Long id) {
        return paymentService.deletePaymentById(id);
    }
}
