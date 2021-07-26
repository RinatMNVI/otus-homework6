package ru.kartezs.billingservice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kartezs.billingservice.common.AccountDto;

@Mapper
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    Account toEntity(AccountDto accountDto);

    AccountDto toDto(Account account);
}
