package br.com.rocha.dan.task.event.publisher;

import br.com.rocha.dan.task.event.receiver.model.Content;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.queue.ex}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    public void produceMsg(Content content){
        amqpTemplate.convertAndSend(exchange, routingKey, content);
        System.out.println("Send msg = " + content);
    }

}