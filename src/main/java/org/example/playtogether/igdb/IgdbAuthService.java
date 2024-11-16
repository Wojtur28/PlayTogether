package org.example.playtogether.igdb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class IgdbAuthService {

    private final IgdbConfig igdbConfig;
    private final RestTemplate restTemplate;
    private String accessToken;
    private Instant expiresAt;

    public String getAccessToken() {
        if (accessToken == null || isTokenExpired()) {
            refreshToken();
        }
        return accessToken;
    }

    private void refreshToken() {
        String url = buildTokenRequestUrl();

        try {
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(new HttpHeaders()), Map.class);
            handleTokenResponse(response);
        } catch (Exception e) {
            log.error("Failed to refresh access token: {}", e.getMessage());
            throw new IllegalStateException("Could not refresh token", e);
        }
    }

    private String buildTokenRequestUrl() {
        return String.format("https://id.twitch.tv/oauth2/token?client_id=%s&client_secret=%s&grant_type=client_credentials",
                igdbConfig.getClientId(), igdbConfig.getClientSecret());
    }

    private void handleTokenResponse(ResponseEntity<Map> response) {
        Map<String, Object> body = response.getBody();
        if (body != null && body.containsKey("access_token") && body.containsKey("expires_in")) {
            this.accessToken = (String) body.get("access_token");
            int expiresIn = (int) body.get("expires_in");

            this.expiresAt = Instant.now().plusSeconds(expiresIn);
        } else {
            log.warn("No access token or expiration time found in response: {}", response.getStatusCode());
        }
    }

    private boolean isTokenExpired() {
        return expiresAt == null || Instant.now().isAfter(expiresAt);
    }
}
