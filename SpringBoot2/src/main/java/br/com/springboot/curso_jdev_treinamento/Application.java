package br.com.springboot.curso_jdev_treinamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EntityScan(basePackages = "br.com.springboot.curso_jdev_treinamento.model")
@ComponentScan(basePackages = {"br.com.springboot.*"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
