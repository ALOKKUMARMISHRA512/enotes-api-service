package com.enotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.enotes.config.AuditorConfig;
import com.enotes.models.Category;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "awareRef") // Enable JPA Auditing
public class EnotesApplication {
	
	@Bean
	public AuditorAware<Integer> awareRef(){
		return new AuditorConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(EnotesApplication.class, args);
	
		
		
	}

}
