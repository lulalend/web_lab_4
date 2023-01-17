package ru.itmo.lab_4;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.itmo.lab_4.security.RSAKeyProperties;

@EnableConfigurationProperties(RSAKeyProperties.class)
@SpringBootApplication
public class Lab4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
