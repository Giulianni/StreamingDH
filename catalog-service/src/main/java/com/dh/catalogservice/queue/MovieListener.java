package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.dto.MovieWS;
import com.dh.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieListener {
    private CatalogServiceImpl catalogService;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload MovieWS movie) {
        catalogService.getMoviesByGenre(movie.getGenre());
    }

}
