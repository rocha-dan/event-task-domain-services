package br.com.rocha.dan.task.event.receiver.model;

import br.com.rocha.dan.task.event.receiver.enums.NotificationTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    private NotificationTypeEnum notificationType;
    private String payload;
}
