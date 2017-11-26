package udea.mercadolibreconsumer.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements MessageListener{

    @Override
    public void onMessage(Message message) {
        System.out.println(message.toString());
    }
}
