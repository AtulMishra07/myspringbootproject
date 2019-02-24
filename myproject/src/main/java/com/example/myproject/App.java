package com.example.myproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entity.CreditRating;
import com.example.service.ICreditRatingService;


/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"/myproject/src/main/java/com/example/controller"})
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
