package ru.kartezs.billingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.kartezs.kafka.common.NotificationMessage;

import static ru.kartezs.kafka.common.Topics.NOTIFICATION_TOPIC;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final KafkaTemplate<String, NotificationMessage> kafkaTemplate;

    public Account createAccountByUserId(Long userId) {
        Account account = new Account();
        account.setUserId(userId);
        return accountRepository.save(account);
    }

    public Account getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId)
                .orElseThrow(NotFoundException::new);
    }

    public Account addBalance(Long userId, Long size) {
        Account account = getAccountByUserId(userId);
        account.setBalance(account.getBalance() + size);
        account = accountRepository.save(account);
        kafkaTemplate.send(NOTIFICATION_TOPIC, new NotificationMessage(userId,
                String.format("Successfully added %d money to account for user %d. Current account balance %d.",
                        size, userId, account.getBalance())));
        return account;
    }

    public Account deleteBalance(Long userId, Long size) {
        Account account = getAccountByUserId(userId);

        if (size > account.getBalance()) {
            String errorMessage = String.format("Operation rejected. Not enough money on user account %d. " +
                    "Current account balance %d, required operation size %d.", userId, account.getBalance(), size);
            kafkaTemplate.send(NOTIFICATION_TOPIC, new NotificationMessage(userId, errorMessage));
            throw new LowBalanceException(errorMessage);
        }
        account.setBalance(account.getBalance() - size);
        account = accountRepository.save(account);
        kafkaTemplate.send(NOTIFICATION_TOPIC, new NotificationMessage(userId,
                String.format("Successfully removed %d money from account for user %d. Current account balance %d.",
                        size, userId, account.getBalance())));
        return account;
    }
}
