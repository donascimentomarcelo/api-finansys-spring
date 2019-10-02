package br.com.finansys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
	
	private static final String PATH_PATTERN = "/**";

	@Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping(PATH_PATTERN)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                .allowCredentials(true)
        ;
    }

}
