package org.example.playtogether.igdb;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class IgdbAuthService {

    private final IgdbConfig igdbConfig;
    private final RestTemplate restTemplate;
    private String accessToken;

    public String getAccessToken() {
        if (accessToken == null || isTokenExpired()) {
            refreshToken();
        }
        return accessToken;
    }

    private void refreshToken() {
        String url = "https://id.twitch.tv/oauth2/token?client_id=" + igdbConfig.getClientId() +
                "&client_secret=" + igdbConfig.getClientSecret() +
                "&grant_type=client_credentials";

        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, new HttpEntity<>(new HttpHeaders()), Map.class);

        Map<String, Object> body = response.getBody();
        if (body != null && body.containsKey("access_token")) {
            this.accessToken = (String) body.get("access_token");
            int expires_in = (int) body.get("expires_in");
        }
    }

    private boolean isTokenExpired() {

        return false;
    }
}
