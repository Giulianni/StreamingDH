package com.dh.queue;

import com.dh.model.Movie;
import com.dh.service.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieSender {
    private MovieServiceImpl client;

    private RabbitTemplate rabbitTemplate;

    private Queue movieQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), client.save(movie));
    }
}
