package com.example.nagoyameshi.csv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Configuration
public class CsvConfig {
	
	@Bean
    public CsvMapper getCsvMapper() {
        return new CsvMapper();
    }

    @Bean
    public CsvSchema getCsvSchema() {
        return CsvSchema.builder().
                build();
    }
}