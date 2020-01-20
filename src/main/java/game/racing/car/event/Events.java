package game.racing.car.event;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private static ThreadLocal<List<EventHandler<?>>> handlers = new ThreadLocal<>();
    private static ThreadLocal<Boolean> publishing = ThreadLocal.withInitial(() -> Boolean.FALSE);

    public static void raise(Object event) {
        if (publishing.get()) {
            return;
        }

        try {
            publishing.set(Boolean.TRUE);

            if (!registerEvent(event)) {
                return;
            }
        } finally {
            publishing.set(Boolean.FALSE);
        }
    }

    private static boolean registerEvent(Object event) {
        List<EventHandler<?>> eventHandlers = handlers.get();
        if (eventHandlers == null) {
            return false;
        }

        for (EventHandler handler : eventHandlers) {
            assignEventToHandler(event, handler);
        }
        return true;
    }

    private static void assignEventToHandler(Object event, EventHandler handler) {
        if (handler.canHandle(event)) {
            handler.handle(event);
        }
    }

    public static void handle(EventHandler<?> hander) {
        if (publishing.get()) {
            return;
        }

        List<EventHandler<?>> eventHandlers = handlers.get();
        if (eventHandlers == null) {
            eventHandlers = new ArrayList<>();
            handlers.set(eventHandlers);
        }
        eventHandlers.add(hander);
    }

    public static void reset() {
        if (!publishing.get()) {
            handlers.remove();
        }
    }
}

