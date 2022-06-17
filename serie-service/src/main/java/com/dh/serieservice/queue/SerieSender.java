package com.dh.serieservice.queue;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieSender {
    private SerieService client;

    private RabbitTemplate rabbitTemplate;

    private Queue serieQueue;

    public void send(Serie serie) {
        this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), client.save(serie));
    }
}
