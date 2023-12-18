package com.ztech.subtly;

import java.io.File;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.apache.commons.io.FileUtils;

@SpringBootApplication
public class SubtlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubtlyApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedHeaders("*").allowedMethods("*");
			}
		};
	}

	@Bean
	public void cleanProcessingDirectory() throws IOException {
		File processing_path = new File(System.getProperty("user.dir"), "processing");
		if (processing_path.exists()) {
			FileUtils.cleanDirectory(processing_path);
		}
	}

}
