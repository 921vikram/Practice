package com.annotations.spring_boot_annotations;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    public Employee() {
        name();
    }

    public void name() {
        System.out.println("my name is vik");
    }
}
