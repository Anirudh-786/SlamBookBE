package com.example.slambook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            // Create uploads directory in the project root using absolute path
            Path uploadDir = Paths.get(System.getProperty("user.dir")).resolve("uploads");
            if (!java.nio.file.Files.exists(uploadDir)) {
                java.nio.file.Files.createDirectories(uploadDir);
            }
            String uploadPath = uploadDir.toFile().getAbsolutePath();
            // Ensure the path ends with a slash for proper file serving
            if (!uploadPath.endsWith(java.io.File.separator)) {
                uploadPath += java.io.File.separator;
            }
            registry.addResourceHandler("/uploads/**")
                    .addResourceLocations("file:///" + uploadPath.replace("\\", "/"));
        } catch (Exception e) {
            System.err.println("Failed to configure upload directory: " + e.getMessage());
        }
    }
}

