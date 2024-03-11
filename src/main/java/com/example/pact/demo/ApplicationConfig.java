package com.example.pact.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@Slf4j
public class ApplicationConfig {

    @Bean
    UserClient userClient(AppEnvConfig appEnvConfig){
        RestClient client = RestClient.builder().baseUrl(appEnvConfig.baseUrl()).build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();
        return factory.createClient(UserClient.class);
    }
}
