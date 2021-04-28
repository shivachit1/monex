package io.shiva.monex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonexApplication {
    public static final Logger logger = LoggerFactory.getLogger(MonexApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(MonexApplication.class, args);
    }

}
