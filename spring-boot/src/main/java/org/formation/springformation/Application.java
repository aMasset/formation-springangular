package org.formation.springformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(LOGGER::info);

    }

}
