package org.example.playtogether.igdb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.playtogether.web.dto.igdb.Game;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class IgdbClient {

    private final RestTemplate restTemplate;
    private final IgdbAuthService igdbAuthService;
    private final IgdbConfig igdbConfig;
    private final ObjectMapper objectMapper;

    public List<Game> fetchGamesPage(int limit, int offset) {
        HttpHeaders headers = buildHeaders();
        String requestBody = buildRequestBody(limit, offset);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        String url = "https://api.igdb.com/v4/multiquery";

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            return handleResponse(response);
        } catch (Exception e) {
            log.error("Failed to fetch games: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    private HttpHeaders buildHeaders() {
        String accessToken = igdbAuthService.getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Client-ID", igdbConfig.getClientId());
        headers.setContentType(MediaType.TEXT_PLAIN);
        return headers;
    }

    private String buildRequestBody(int limit, int offset) {
        return String.format("""
                query games "Games with Expanded Fields" {
                    fields id,
                           name,
                           genres.name,
                           themes.name,
                           screenshots.image_id,
                           rating,
                           platforms.name;
                    where themes != null & genres != null & themes != 42 & rating != 0;
                    limit %d;
                    offset %d;
                };
                """, limit, offset);
    }

    private List<Game> handleResponse(ResponseEntity<String> response) {
        if (response.getStatusCode() == HttpStatus.OK) {
            return parseGames(response.getBody());
        } else {
            log.warn("Unexpected response status: {}", response.getStatusCode());
            return new ArrayList<>();
        }
    }

    private List<Game> parseGames(String json) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode resultNode = rootNode.get(0).path("result");

            if (resultNode == null || !resultNode.isArray() || resultNode.isEmpty()) {
                return new ArrayList<>();
            }

            return objectMapper.convertValue(
                    resultNode,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Game.class)
            );
        } catch (JsonProcessingException e) {
            log.error("Failed to parse IGDB response: {}", e.getMessage());
            return new ArrayList<>();
        }
    }
}

