package ru.kartezs.orderservice;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.kartezs.billingservice.common.AccountOperationDto;
import ru.kartezs.billingservice.common.BillingServiceClient;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BillingServiceClient billingServiceClient;

    public Order create(Order order) {
        try {
            billingServiceClient.removeBalance(order.getUserId(), new AccountOperationDto(order.getPrice()));
        } catch (FeignException exception) {
            if (exception.status() == HttpStatus.BAD_REQUEST.value()) {
                throw new CreateOrderException(exception.getMessage());
            }
            throw exception;
        }
        return orderRepository.save(order);
    }
}
