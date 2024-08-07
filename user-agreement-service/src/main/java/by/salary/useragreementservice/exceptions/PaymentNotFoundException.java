package by.salary.useragreementservice.exceptions;

import org.springframework.http.HttpStatus;

public class PaymentNotFoundException extends AbstractException {

    private final HttpStatus status;

    public PaymentNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
