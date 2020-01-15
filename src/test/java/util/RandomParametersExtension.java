package util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

public class RandomParametersExtension implements ParameterResolver {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface Random {
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(Random.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return getRandomValue(parameterContext.getParameter(), extensionContext);
    }

    private Integer getRandomValue(final Parameter parameter, final ExtensionContext extensionContext) {

        /**
         * 들어온 값에 대한 타입 체킹 및 랜덤 함수 이용, 랜덤 값 반환.
         */

        Class<?> type = parameter.getType();

        // 사용하는 랜덤 클래스 객체 획득.
//        java.util.Random random = extensionContext.getRoot()
//                .getStore(ExtensionContext.Namespace.GLOBAL)
//                .getOrComputeIfAbsent(java.util.Random.class);

        if (int.class.equals(type)) {
            /** 1 ~ 10 : 1 포함, 10 제외 **/
            return ThreadLocalRandom.current().nextInt(1, 10);
        }

        throw new ParameterResolutionException("No Random generator implements for " + type);
    }
}
