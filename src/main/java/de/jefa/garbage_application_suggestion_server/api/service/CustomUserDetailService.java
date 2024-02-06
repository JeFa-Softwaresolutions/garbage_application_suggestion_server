package de.jefa.garbage_application_suggestion_server.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.jefa.garbage_application_suggestion_server.api.model.dummy.ApiUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static java.util.Objects.requireNonNull;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final WebClient webClient;

    public CustomUserDetailService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final ApiUser loadedApiUser = getUserName(username).block();
        return User.builder()
                .username(requireNonNull(loadedApiUser).getUsername())
                .password(loadedApiUser.getPassword())
                .roles("USER")
                .build();
    }

    public Mono<ApiUser> getUserName(String username) {
        return this.webClient
                .get()
                .uri("/{username}", username)
                .retrieve()
                .bodyToMono(String.class)
                .handle((response, sink) -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        sink.next(objectMapper.readValue(response, ApiUser.class));
                    } catch (JsonProcessingException e) {
                        sink.error(new RuntimeException("Fehler beim Parsen der Antwort", e));
                    }
                });
    }
}
