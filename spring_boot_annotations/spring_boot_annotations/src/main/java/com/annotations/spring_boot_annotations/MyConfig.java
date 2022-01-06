package com.annotations.spring_boot_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
@ComponentScan(basePackages = {"test"})
public class MyConfig {

    // Configuration class will generate bean class and return it
    @Bean("student1")
    @Lazy
    public Student getStudent() {
        System.out.println("Creating student object");
        return new Student();
    }

    @Bean("student2")
    public Student getFirstStudent() {
        System.out.println("Creating first");
        return new Student();
    }

    @Bean
    public Date getDate() {
        System.out.println("Create date ");
        return new Date();
    }
}
