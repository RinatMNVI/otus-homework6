package ru.kartezs.orderservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CreateOrderException extends RuntimeException {
    public CreateOrderException(String message) {
        super(message);
    }
}
