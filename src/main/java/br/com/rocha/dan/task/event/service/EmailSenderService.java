package br.com.rocha.dan.task.event.service;

import br.com.rocha.dan.task.event.receiver.model.Content;

public interface EmailSenderService {

    void sendEmail(Content content);
}
