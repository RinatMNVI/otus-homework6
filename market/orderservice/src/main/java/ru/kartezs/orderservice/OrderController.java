package ru.kartezs.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/{userId}")
    public OrderDto create(@PathVariable(name = "userId") Long userId, @RequestBody OrderDto dto) {
        return orderMapper.toDto(orderService.create(orderMapper.toEntity(dto, userId)));
    }
}
