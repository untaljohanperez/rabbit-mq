package udea.regalosnavidadapi.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import udea.regalosnavidadapi.model.RabbitMessage;
import udea.regalosnavidadapi.rabbitconf.RabbitConf;

import java.util.concurrent.CompletableFuture;

@Component
public class Publisher {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RabbitConf.class);
    RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);

    public void publicarMensaje(RabbitMessage rabbitMessage) {
        rabbitTemplate.convertAndSend(rabbitMessage.getExchange(), rabbitMessage.getRoutingKey(), rabbitMessage.getMessage());
    }

    public void publicarMensajeAsync(RabbitMessage rabbitMessage) {
        CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(rabbitMessage.getExchange(), rabbitMessage.getRoutingKey(), rabbitMessage.getMessage()));
    }
}
