package ru.kartezs.notification;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.kartezs.kafka.common.Topics.NOTIFICATION_TOPIC;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic NotificationTopic() {
        return new NewTopic(NOTIFICATION_TOPIC, 1, (short) 1);
    }
}
