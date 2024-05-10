package spring_project.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import spring_project.controller.UpdateController;
import spring_project.service.AnswerConsumer;

import static spring_project.model.RabbitQueue.ANSWER_MESSAGE_UPDATE;

@Service
public class AnswerConsumerImpl implements AnswerConsumer {
    private final UpdateController updateController;

    public AnswerConsumerImpl(UpdateController updateController) {
        this.updateController = updateController;
    }


    @Override
    @RabbitListener(queues = ANSWER_MESSAGE_UPDATE)
    public void consume(SendMessage message) {
        updateController.setView(message);
    }
}
