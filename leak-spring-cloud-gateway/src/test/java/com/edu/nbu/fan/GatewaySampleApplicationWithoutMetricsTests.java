package com.edu.nbu.fan;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.test.ClassPathExclusions;
import org.springframework.cloud.test.ModifiedClassPathRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/29-5:06 PM
 * @since 1.0
 */
@RunWith(ModifiedClassPathRunner.class)
@ClassPathExclusions({ "micrometer-*.jar", "spring-boot-actuator-*.jar", "spring-boot-actuator-autoconfigure-*.jar" })
@DirtiesContext
public class GatewaySampleApplicationWithoutMetricsTests {
    static protected int port;

    protected WebTestClient webClient;

    protected String baseUri;

    @BeforeClass
    public static void beforeClass() {
        port = TestSocketUtils.findAvailableTcpPort();
        System.setProperty("server.port", Integer.toString(port));
    }

    @AfterClass
    public static void afterClass() {
        System.clearProperty("server.port");
    }

    @Before
    public void setup() {
        baseUri = "http://localhost:" + port;
        this.webClient = WebTestClient.bindToServer().responseTimeout(Duration.ofSeconds(10)).baseUrl(baseUri).build();
    }

    protected ConfigurableApplicationContext init(Class<?> config) {
        return new SpringApplicationBuilder().web(WebApplicationType.REACTIVE)
                .sources(GatewaySampleApplication.class, config).run();
    }

    @Test
    public void actuatorMetrics() {
        init(GatewaySampleApplicationTests.TestConfig.class);
        webClient.get().uri("/get").exchange().expectStatus().isOk();
        webClient.get().uri("http://localhost:" + port + "/actuator/metrics/spring.cloud.gateway.requests").exchange()
                .expectStatus().isOk().expectBody(String.class)
                .isEqualTo(GatewaySampleApplication.HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS);
    }

}
