package com.metadata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.metadata.mapper"})
public class MetadataInformationFillingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetadataInformationFillingSystemApplication.class, args);
    }

}
