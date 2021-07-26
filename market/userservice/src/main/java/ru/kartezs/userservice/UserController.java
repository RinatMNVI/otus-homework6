package ru.kartezs.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public UserDto create(@RequestBody @Validated UserDto user) {
        return userMapper.toDto(userService.create(userMapper.toEntity(user)));
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable(name = "id") Long id) {
        return userMapper.toDto(userService.findById(id));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable(name = "id") Long id, @RequestBody @Validated User user) {
        return userMapper.toDto(userService.update(id, user));
    }

}
