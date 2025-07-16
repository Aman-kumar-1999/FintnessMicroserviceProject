package com.fitness.aigeminiservice.services;

import com.fitness.aigeminiservice.module.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityMessageListener {
    // This class will handle messages from the RabbitMQ queue


    // Method to handle incoming messages
     @RabbitListener(queues = "${rabbitmq.queue.name}")
     public void receiveMessage(Activity activity) {

            System.out.println("Received activity: " + activity);

     }
}
