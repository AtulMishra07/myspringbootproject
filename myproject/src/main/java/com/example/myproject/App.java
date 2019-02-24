package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = CreditRatingController.class)
public class App 
{
	
	@RequestMapping("/")
	String home() {
		return "Hello World : Successful Deployment";
	}
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
