package spring_project.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import spring_project.service.UpdateProducer;

@Service
@Log4j
public class UpdateProductImpl implements UpdateProducer {

    private final RabbitTemplate rabbitTemplate;

    public UpdateProductImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void produce(String rabbitQueue, Update update) {
        log.debug(update.getMessage().getText());
        rabbitTemplate.convertAndSend(rabbitQueue,update);
    }
    //класс и методы нужен для интеграции с брокером RabbitMQ
}
