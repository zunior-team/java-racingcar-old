package game.racing.car.event;

import net.jodah.typetools.TypeResolver;

public interface EventHandler<T> {
    void handle(T event);

    // DDD Start Event 참고.
    // TypeResolver는 EventHandler의 파라미터화 타입을 구하는 기능 제공.
    default boolean canHandle(Object event) {
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(EventHandler.class, this.getClass());
        return typeArgs[0].isAssignableFrom(event.getClass());
    }
}
