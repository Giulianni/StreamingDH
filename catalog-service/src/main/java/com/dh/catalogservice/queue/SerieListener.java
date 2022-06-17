package com.dh.catalogservice.queue;

import com.dh.catalogservice.model.dto.SerieWS;
import com.dh.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieListener {

    private CatalogServiceImpl catalogService;

    @RabbitListener(queues = { "${queue.serie.name}" })
    public void receive(@Payload SerieWS serie) {
        catalogService.getSeriesByGenre(serie.getGenre());
    }
}
