package ru.kartezs.billingservice.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class AccountOperationDto {

    @Min(value = 0L)
    private Long size;

    public AccountOperationDto(Long size) {
        this.size = size;
    }
}
