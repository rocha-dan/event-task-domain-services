package br.com.rocha.dan.task.event.service.impl;

import br.com.rocha.dan.task.event.model.EmailSenderTO;
import br.com.rocha.dan.task.event.receiver.model.Content;
import br.com.rocha.dan.task.event.service.EmailSenderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {


    @Autowired
    private Gson gson = new Gson();

    @Override
    public void sendEmail(Content content) {
        System.out.println("Email sended to: " + gson.fromJson(content.getPayload(), EmailSenderTO.class).getEmail());

    }
}
