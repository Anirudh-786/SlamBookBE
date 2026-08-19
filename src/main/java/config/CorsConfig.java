package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Applies CORS configuration to all paths
                        .allowedOrigins("http://localhost:8081") // Allows your React development port
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Accepts preflight requests
                        .allowedHeaders("*") // Allows all header fields sent by client
                        .allowCredentials(true);
            }
        };
    }
}
