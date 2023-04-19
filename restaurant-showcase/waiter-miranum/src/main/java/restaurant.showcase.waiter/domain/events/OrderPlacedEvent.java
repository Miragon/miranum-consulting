package restaurant.showcase.waiter.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import restaurant.showcase.waiter.domain.Order;

@AllArgsConstructor
@Getter
public class OrderPlacedEvent {
    private final Order order;
}