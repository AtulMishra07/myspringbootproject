package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("cifRating")
public class CreditRatingController {
	
	@Autowired
	private ICreditRatingService creditRatingService;
	
	@GetMapping("creditRating/sample")
	public String getCreditRatingByCIFNBR() {
		return "Hello World";
	}
	
	@GetMapping("creditRating/{cif_nbr}")
	public ResponseEntity<CreditRating> getCreditRatingByCIFNBR(@PathVariable("cif_nbr") String cifnbr) {
		CreditRating creditRating = creditRatingService.getCreditRatingByCIFNBR(cifnbr);
		return new ResponseEntity<CreditRating>(creditRating, HttpStatus.OK);
	}
	
	@GetMapping("creditRatings")
	public ResponseEntity<List<CreditRating>> getCreditRatings() {
		List<CreditRating> creditRatings = creditRatingService.getAllCreditRating();
		return new ResponseEntity<List<CreditRating>>(creditRatings, HttpStatus.OK);
	}
	
	@PostMapping("creditRating")
	public ResponseEntity<Void> addCreditRating(@RequestBody CreditRating creditRating, UriComponentsBuilder builder) {
		boolean flag = creditRatingService.addCreditRatingForCIF(creditRating);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders header = new HttpHeaders();
		header.setLocation(builder.path("/cif/cif_nbr").buildAndExpand(creditRating.getCif_nbr()).toUri());
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@PutMapping("creditRating")
	public ResponseEntity<CreditRating> updateCreditEntity(@RequestBody CreditRating creditRating) {
		boolean flag = creditRatingService.updateCreditRatingForCIF(creditRating);
		if(flag == false) {
			return new ResponseEntity<CreditRating>(creditRating, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CreditRating>(creditRating, HttpStatus.OK);
	}
	
	@DeleteMapping("creditRating")
	public ResponseEntity<CreditRating> deleteCreditEntity(@RequestBody CreditRating creditRating) {
		boolean flag = creditRatingService.deleteCreditRatingForCIF(creditRating);
		if(flag == false) {
			return new ResponseEntity<CreditRating>(creditRating, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CreditRating>(creditRating, HttpStatus.OK);
	}
	
}
