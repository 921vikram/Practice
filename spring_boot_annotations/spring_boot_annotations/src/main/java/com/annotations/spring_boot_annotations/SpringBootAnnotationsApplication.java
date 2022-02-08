package com.annotations.spring_boot_annotations;

import com.annotations.spring_boot_annotations.model.User;
import com.annotations.spring_boot_annotations.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import test.Dog;

import java.util.Date;

@SpringBootApplication
@Configuration
public class SpringBootAnnotationsApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("student2")
	private Student student;
	@Autowired
	private Date date;
	@Autowired
	private Employee employee;

	@Autowired
	UserService userService;

	@Autowired
	private Dog dog;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.studing();
		//User u = userService.addUser();
		//System.out.println(u);
		List<User> uu = userService.getUsers();
		for(User i : uu) {
			System.out.println("User "+i);
		}
	}
}
