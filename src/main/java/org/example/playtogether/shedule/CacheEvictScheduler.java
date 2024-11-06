package org.example.playtogether.shedule;

import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CacheEvictScheduler {

    private final CacheManager cacheManager;

    @Scheduled(fixedRate = 21600000)
    public void evictGamesPagesCache() {
        cacheManager.getCache("gamesPages").clear();
    }
}
