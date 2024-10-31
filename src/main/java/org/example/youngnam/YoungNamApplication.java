package org.example.youngnam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YoungNamApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoungNamApplication.class, args);
    }

}
