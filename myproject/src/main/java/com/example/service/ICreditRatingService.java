/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.entity.CreditRating;

/**
 * @author Atul Mishra
 *
 */
public interface ICreditRatingService {
	public List<CreditRating> getAllCreditRating();
	public CreditRating getCreditRatingByCIFNBR(String cif_nbr);
	public boolean addCreditRatingForCIF(CreditRating creditRating);
	public boolean updateCreditRatingForCIF(CreditRating creditRating);
	public boolean deleteCreditRatingForCIF(CreditRating creditRating);
}
