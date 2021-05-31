package pl.kmiecik.sbkaop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Hello {
    @EventListener(ApplicationReadyEvent.class)
    @AspectHello
    public void sayHello() {
        System.out.println("Hello");
    }

}
