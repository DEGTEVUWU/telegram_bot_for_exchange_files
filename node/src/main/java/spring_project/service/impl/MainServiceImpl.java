package spring_project.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import spring_project.dao.RawDataDAO;
import spring_project.entity.RawData;
import spring_project.service.MainService;
import spring_project.service.ProducerService;

@AllArgsConstructor
@Service
public class MainServiceImpl implements MainService {
    private RawDataDAO rawDataDAO;
    private ProducerService producerService;

    @Override
    public void processTextMessage(Update update) {
        saveRawData(update);

        var message = update.getMessage();
        var sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from NODE, from MainService!");
        producerService.producerAnswer(sendMessage);
    }

    private void saveRawData(Update update) {
        RawData rawData = RawData.builder()
                .event(update)
                .build();
        rawDataDAO.save(rawData);
    }
}
