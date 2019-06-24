package br.com.rocha.dan.task.event.subcriber;

import br.com.rocha.dan.task.event.receiver.model.Content;
import br.com.rocha.dan.task.event.service.EmailSenderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "event-task")
public class Subcriber {

    @Autowired
    private EmailSenderService service;

    @RabbitHandler
    public void receivedMessage(Content content) throws InterruptedException {

        System.out.println("Received Message: " + content.toString());
        service.sendEmail(content);

    }

}