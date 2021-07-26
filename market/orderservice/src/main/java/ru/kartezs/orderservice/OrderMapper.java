package ru.kartezs.orderservice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderDto orderDto, Long userId);

    OrderDto toDto(Order order);
}
