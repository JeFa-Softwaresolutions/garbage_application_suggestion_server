package de.jefa.garbage_application_suggestion_server.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class WebClientConfig {

    private final String securityServerUrl;
    private final String basicAuth;

    public WebClientConfig(
            @Value("${security.server.base-url}") String securityServerUrl,
            @Value("${security.server.username}") String username,
            @Value("${security.server.password}") String password) {
        this.securityServerUrl = securityServerUrl;
        this.basicAuth = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }

    @Bean
    public WebClient webClientWithBasicAuth() {
        return WebClient.builder()
                .baseUrl(securityServerUrl)
                .defaultHeader(AUTHORIZATION, basicAuth)
                .build();
    }
}
