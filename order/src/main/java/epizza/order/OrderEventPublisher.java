package epizza.order;

import epizza.shared.event.EventPublisher;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderEventPublisher {

    private final EventPublisher eventPublisher;
    private final EntityLinks entityLinks;

    public void sendOrderCreatedEvent(Order order) {
        String href = entityLinks.linkForSingleResource(Order.class, order.getId()).toUri().toString();
        eventPublisher.publish("OrderCreated", ImmutableMap.of("orderLink", href));
    }
}
