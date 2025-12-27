package com.microservice.servicevoiture;

import com.microservice.servicevoiture.entities.Car;
import com.microservice.servicevoiture.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceVoitureApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(CarRepository carRepository) {
        return args -> {
            if (carRepository.count() == 0) {
                carRepository.save(new Car(null, "Toyota", "ABC123", "Camry", 1L, null));
                carRepository.save(new Car(null, "Honda", "XYZ789", "Civic", 2L, null));
                carRepository.save(new Car(null, "Ford", "DEF456", "Focus", 1L, null));
                System.out.println("Database initialized with sample cars!");
            }
        };
    }


    /**
     * Configure RestTemplate pour la communication inter-services
     * @return Instance configurée de RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // Configuration des timeouts
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }
}