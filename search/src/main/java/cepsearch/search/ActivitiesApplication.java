package cepsearch.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "cepsearch.search")
@SpringBootApplication
public class ActivitiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiesApplication.class, args);
    }

}
