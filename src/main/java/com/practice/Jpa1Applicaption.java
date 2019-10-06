package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.cloud.client.discovery.EnableDiscoveryClient;*/
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableDiscoveryClient
@EntityScan("com.example.projectMGMT.models")
@EnableAutoConfiguration
@EnableJpaRepositories("com.example.projectMGMT.dao")
@ComponentScan(basePackages = "com.example.projectMGMT")
public class Jpa1Applicaption {

	public static void main(String[] args) {
		SpringApplication.run(Jpa1Applicaption.class, args);
	}


	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200", "http://localhost:4200/", "http://localhost:4100",
								"http://localhost:4100/", "http://localhost:8084", "http://localhost:8084/"

						).allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
						// .allowedHeaders("auth_token", "Content-Type")
						.exposedHeaders("custom-header1", "custom-header2").allowCredentials(false).maxAge(4800);

//	                String urls = env.getProperty("cors.urls");
//	                CorsRegistration reg = registry.addMapping("/**");
//	                for (String url : urls.split(",")) {
//	                    reg.allowedOrigins(url);
//	                }
			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/resources/**").addResourceLocations("/resources/",
						"classpath:/other-resources/");
			}
		};
	}
	
}
