package net.tirasa.syncope.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath*:/*Context.xml")
public class SyncopeCoreApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SyncopeCoreApplication.class, args);
    }
}
