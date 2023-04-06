package restaurant.showcase.waiter.kafka;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
@Deployment(resources = {"classpath:/pizzaEvino.bpmn"})
public class ServiceAsync {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAsync.class, args);
    }
}
