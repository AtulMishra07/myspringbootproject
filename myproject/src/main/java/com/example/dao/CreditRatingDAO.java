/**
 * 
 */
package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.CreditRating;

/**
 * @author Atul Mishra
 *
 */
@Transactional
@Repository
public class CreditRatingDAO implements ICreditRatingDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.example.dao.ICreditRatingDAO#getAllCreditRatings()
	 */
	@Override
	public List<CreditRating> getAllCreditRatings() {
		String hql = "FROM CreditRating as creditRating ORDER BY creditRating.cif_nbr";
		return (List<CreditRating>) entityManager.createQuery(hql).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.example.dao.ICreditRatingDAO#getCreditRatingByCifNBR(java.lang.String)
	 */
	@Override
	public CreditRating getCreditRatingByCifNBR(String cif_nbr) {
		String hql = "FROM CreditRating as creditRating where creditRating.cif_nbr="+cif_nbr;
		return (CreditRating) entityManager.createQuery(hql).getSingleResult();
	}

	/* (non-Javadoc)
	 * @see com.example.dao.ICreditRatingDAO#addCIFRating(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addCIFRating(CreditRating creditRating) {
		if(creditRating != null && creditRating.getCif_nbr() != null 
				&& creditRating.getCif_nbr().length() > 0 && !ratingExistForCIF(creditRating.getCif_nbr())) {
			entityManager.persist(creditRating);
			return true;
		}		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.example.dao.ICreditRatingDAO#updateCIFRating(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateCIFRating(CreditRating creditRating) {
		if(creditRating != null && creditRating.getCif_nbr() != null 
				&& creditRating.getCif_nbr().length() > 0 && ratingExistForCIF(creditRating.getCif_nbr())) {
			CreditRating creditRatingFromDB = getCreditRatingByCifNBR(creditRating.getCif_nbr());
			creditRatingFromDB.setRating(creditRating.getRating());
			entityManager.flush();
			return true;
		}		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.example.dao.ICreditRatingDAO#deleteCIFRating(java.lang.String)
	 */
	@Override
	public boolean deleteCIFRating(CreditRating creditRating) {
		if(creditRating != null && creditRating.getCif_nbr() != null 
				&& creditRating.getCif_nbr().length() > 0 && ratingExistForCIF(creditRating.getCif_nbr())) {
			CreditRating creditRatingFromDB = getCreditRatingByCifNBR(creditRating.getCif_nbr());
			entityManager.remove(creditRatingFromDB);
			return true;
		}		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.example.dao.ICreditRatingDAO#ratingExist(java.lang.String)
	 */
	@Override
	public boolean ratingExistForCIF(String cif_nbr) {
		String hql = "FROM CreditRating as creditRating where creditRating.cif_nbr="+cif_nbr;
		CreditRating creditRating = (CreditRating) entityManager.createQuery(hql).getSingleResult();
		if(creditRating != null && creditRating.getRating() != null && creditRating.getRating().length() > 0 ) {
			return true;
		}		 
		return false;
	}

	@Override
	public CreditRating getCreditRatingByPartnerID(int partner_id) {
		return entityManager.find(CreditRating.class, partner_id);
	}

}
