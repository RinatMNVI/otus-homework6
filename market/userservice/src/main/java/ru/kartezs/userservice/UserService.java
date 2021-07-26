package ru.kartezs.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kartezs.billingservice.common.BillingServiceClient;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BillingServiceClient billingServiceClient;

    public User create(User user) {
        User saved = userRepository.save(user);
        billingServiceClient.createNewAccount(saved.getId());
        return saved;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public User update(Long id, User user) {
        User userFromDb = findById(id);
        return userRepository.save(userMapper.update(userFromDb, user));
    }


}
