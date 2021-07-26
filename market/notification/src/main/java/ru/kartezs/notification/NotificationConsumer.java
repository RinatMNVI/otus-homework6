package ru.kartezs.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.kartezs.kafka.common.NotificationMessage;

import static ru.kartezs.kafka.common.Topics.NOTIFICATION_TOPIC;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = {NOTIFICATION_TOPIC})
    private void createdUserConsumer(NotificationMessage notificationMessage) {
        Notification notification = new Notification();
        notification.setMessage(notificationMessage.getMessage());
        notification.setUserId(notificationMessage.getUserId());
        notificationService.send(notification);
    }
}
