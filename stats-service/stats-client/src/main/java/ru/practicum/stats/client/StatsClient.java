package ru.practicum.stats.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.StatsDto;

import java.util.List;

@Service
public class StatsClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public StatsClient(RestTemplate restTemplate, @Value("${stats-service.uri}") String serverUrl) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    public void saveHit(HitDto hitDto) {
        restTemplate.postForObject(serverUrl + "/hit", hitDto, Void.class);
    }

    public List<StatsDto> getStats(String start, String end, List<String> uris, boolean unique) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl + "/stats")
                .queryParam("start", start)
                .queryParam("end", end)
                .queryParam("unique", unique);

        if (uris != null && !uris.isEmpty()) {
            for (String uri : uris) {
                builder.queryParam("uris", uri);
            }
        }

        ResponseEntity<List<StatsDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }
}
