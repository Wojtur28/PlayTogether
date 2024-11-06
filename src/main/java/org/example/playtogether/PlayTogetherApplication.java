package org.example.playtogether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlayTogetherApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayTogetherApplication.class, args);
    }

}
