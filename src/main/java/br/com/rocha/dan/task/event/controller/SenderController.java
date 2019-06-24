package br.com.rocha.dan.task.event.controller;

import br.com.rocha.dan.task.event.publisher.Publisher;
import br.com.rocha.dan.task.event.receiver.model.Content;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private Gson gson = new Gson();

    @Autowired
    Publisher publisher;

    @GetMapping("/send")
    public String sendMessage() {

        String payload = "{ \"notificationType\":\"PENDING\", \"payload\":\"{'email':'daniel@teste.com'}\" }";
        Content content = gson.fromJson(payload, Content.class);
        publisher.produceMsg(content);

        return "Successfully Msg Sent";
    }
}