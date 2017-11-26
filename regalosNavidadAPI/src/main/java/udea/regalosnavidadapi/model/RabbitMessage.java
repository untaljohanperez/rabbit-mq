package udea.regalosnavidadapi.model;

public class RabbitMessage {

    private String exchange;
    private String routingKey;
    private String message;

    public RabbitMessage(String exchange, String routingKey, String message) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.message = message;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public String getMessage() {
        return message;
    }
}
