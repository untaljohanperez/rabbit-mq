package udea.regalosnavidadapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegalosNavidadApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegalosNavidadApiApplication.class, args);
	}
}
