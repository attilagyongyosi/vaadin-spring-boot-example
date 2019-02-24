package com.github.attilagyongyosi.vsw.app;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.github.attilagyongyosi.vsw")
@EnableVaadin("com.github.attilagyongyosi.vsw")
@EntityScan(basePackages = "com.github.attilagyongyosi.vsw")
@EnableJpaRepositories(basePackages = "com.github.attilagyongyosi.vsw")
public class VaadinSpringWebapp {
    public static void main(final String... args) {
        SpringApplication.run(VaadinSpringWebapp.class);
    }
}
