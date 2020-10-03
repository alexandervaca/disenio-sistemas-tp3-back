package ar.com.ifts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
 * @author Alex
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class TP3Application {
	
	public static void main(String[] args) {

		SpringApplication.run(TP3Application.class, args);
	}
}
