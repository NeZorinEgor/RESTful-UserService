package ru.neZorinEgor.userService.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeensConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
