package ru.kartezs.billingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kartezs.billingservice.common.AccountDto;
import ru.kartezs.billingservice.common.AccountOperationDto;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping("/{userId}")
    public AccountDto getBalance(@PathVariable(name = "userId") Long userId) {
        return accountMapper.toDto(accountService.getAccountByUserId(userId));
    }

    @PostMapping("/{userId}")
    public AccountDto createNewAccount(@PathVariable(name = "userId") Long userId) {
        return accountMapper.toDto(accountService.createAccountByUserId(userId));
    }

    @PostMapping("/{userId}/balance")
    public AccountDto addBalance(@PathVariable(name = "userId") Long userId,
                                 @RequestBody @Validated AccountOperationDto operationDto) {
        return accountMapper.toDto(accountService.addBalance(userId, operationDto.getSize()));
    }

    @DeleteMapping("/{userId}/balance")
    public AccountDto changeBalance(@PathVariable(name = "userId") Long userId,
                                    @RequestBody @Validated AccountOperationDto operationDto) {
        return accountMapper.toDto(accountService.deleteBalance(userId, operationDto.getSize()));
    }
}
