package com.fitness.microservices.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final WebClient webClient;

    public boolean validate(String userId){
        try{
            return Boolean.TRUE.equals(webClient.get()
                    .uri("api/v1/users/validate/{userId}",userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block()
            );
        } catch (WebClientResponseException e) {
            if(e.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new RuntimeException("User not Found : "+userId);
            else if (e.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new RuntimeException("Invalid Request : "+userId);
        }
        return false;
    }

}
