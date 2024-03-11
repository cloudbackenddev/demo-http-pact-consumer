package com.example.pact.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Optional;

@HttpExchange(url = "/api/users",accept = MediaType.APPLICATION_JSON_VALUE)
public interface UserClient {
    @PostExchange
    Optional<UserDTO> createUser(@RequestBody CreateUserCommand createUserCommand);
}
