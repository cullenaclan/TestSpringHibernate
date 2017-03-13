package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
@ImportResource("classpath:Spring-Module.xml")
public class MainClass {

	
	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
	}
	
	
}
