package ru.kartezs.billingservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LowBalanceException extends RuntimeException {

    public LowBalanceException(String message) {
        super(message);
    }
}
