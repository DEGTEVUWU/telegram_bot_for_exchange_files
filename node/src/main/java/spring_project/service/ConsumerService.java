package spring_project.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface ConsumerService {
    void consumeTextMessageUpdate(Update update);
    void consumePhotoMessageUpdate(Update update);
    void consumeDocMessageUpdate(Update update);
}