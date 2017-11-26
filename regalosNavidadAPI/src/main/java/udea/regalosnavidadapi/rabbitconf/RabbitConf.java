package udea.regalosnavidadapi.rabbitconf;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost", 5672);
        cachingConnectionFactory.setUsername("regalos");
        cachingConnectionFactory.setPassword("regalos");
        cachingConnectionFactory.setChannelCacheSize(10000);
        cachingConnectionFactory.setRequestedHeartBeat(30);
        return  cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }
}
