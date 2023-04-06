package restaurant.showcase.waiter.kafka.service;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component(value = "tellCheckoutAboutOrder")
public class TellCeckoutSomething {
    private final RestTemplate restTemplate;

    public TellCeckoutSomething(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @JobWorker(type = "tellCheckout")
    public void tellCheckoutAboutOrder(@Variable String orderMessage, @Variable String customerName) {
        restTemplate.put(URI.create("http://localhost:8082/messageForCheckout/"), new OrderRO(orderMessage, customerName));
        System.out.println(customerName + " Ready!");
    }
}
