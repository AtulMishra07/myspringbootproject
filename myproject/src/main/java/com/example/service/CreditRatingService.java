package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ICreditRatingDAO;
import com.example.entity.CreditRating;

@Service
public class CreditRatingService implements ICreditRatingService {
	
	@Autowired
	private ICreditRatingDAO creditRatingDAO;

	@Override
	public List<CreditRating> getAllCreditRating() {
		return creditRatingDAO.getAllCreditRatings();
	}

	@Override
	public CreditRating getCreditRatingByCIFNBR(String cif_nbr) {
		return creditRatingDAO.getCreditRatingByCifNBR(cif_nbr);
	}

	@Override
	public boolean addCreditRatingForCIF(CreditRating creditRating) {
		return creditRatingDAO.addCIFRating(creditRating);
	}

	@Override
	public boolean updateCreditRatingForCIF(CreditRating creditRating) {
		return creditRatingDAO.updateCIFRating(creditRating);
	}

	@Override
	public boolean deleteCreditRatingForCIF(CreditRating creditRating) {
		return creditRatingDAO.deleteCIFRating(creditRating);
	}

}
