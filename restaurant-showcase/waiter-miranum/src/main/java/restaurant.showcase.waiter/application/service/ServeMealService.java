package restaurant.showcase.waiter.application.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import restaurant.showcase.waiter.application.port.in.serveMeal.ServeMealInCommand;
import restaurant.showcase.waiter.application.port.in.serveMeal.ServeMealUseCase;
import restaurant.showcase.waiter.application.port.out.notifyCustomer.NotifyCustomerOutCommand;
import restaurant.showcase.waiter.application.port.out.notifyCustomer.NotifyCustomerOutPort;
import restaurant.showcase.waiter.domain.Order;
import restaurant.showcase.waiter.domain.events.order.MealServedEvent;

@Service
@AllArgsConstructor
public class ServeMealService implements ServeMealUseCase {

    private final NotifyCustomerOutPort notifyCustomerOutPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void serveMeal(ServeMealInCommand serveMealInCommand) {
        var order = new Order(serveMealInCommand);
        String message = String.format("Here is your %s, %s", order.getFood().getName(), order.getCustomerName());
        notifyCustomerOutPort.notifyCustomer(new NotifyCustomerOutCommand(order.getOrderId(), message));
        applicationEventPublisher.publishEvent(new MealServedEvent(order));
    }
}
