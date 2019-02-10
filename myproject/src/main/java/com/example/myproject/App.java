package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
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
