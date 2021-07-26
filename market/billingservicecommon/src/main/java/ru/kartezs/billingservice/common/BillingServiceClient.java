package ru.kartezs.billingservice.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "billingservice", path = "account")
public interface BillingServiceClient {

    @DeleteMapping("/{userId}/balance")
    void removeBalance(@PathVariable(name = "userId") Long userId, AccountOperationDto accountOperationDto);

    @PostMapping("/{userId}")
    void createNewAccount(@PathVariable(name = "userId") Long userId);
}
