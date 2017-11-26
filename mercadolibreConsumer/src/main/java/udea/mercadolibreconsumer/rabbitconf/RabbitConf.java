package udea.mercadolibreconsumer.rabbitconf;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import udea.mercadolibreconsumer.rabbit.Consumer;

@Configuration
public class RabbitConf {

    @Autowired
    Consumer consumer;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost", 5672);
        connectionFactory.setUsername("mercadolibre");
        connectionFactory.setPassword("mercadolibre");
        connectionFactory.setChannelCacheSize(10000);
        connectionFactory.setRequestedHeartBeat(30);
        return  connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(consumer);
        container.setQueueNames("udea.regalos.mercadolibre.regalovendido");
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return container;
    }
}