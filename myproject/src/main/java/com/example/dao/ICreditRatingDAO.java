package com.example.dao;

import java.util.List;

import com.example.entity.CreditRating;

public interface ICreditRatingDAO {
	public CreditRating getCreditRatingByPartnerID(int partner_id);
	public List<CreditRating> getAllCreditRatings();
	public CreditRating getCreditRatingByCifNBR(String cif_nbr);
	public boolean addCIFRating(CreditRating credtiRating);
	public boolean updateCIFRating(CreditRating credtiRating);
	public boolean deleteCIFRating(CreditRating credtiRating);
	public boolean ratingExistForCIF(String cif_nbr);
	
	
}
