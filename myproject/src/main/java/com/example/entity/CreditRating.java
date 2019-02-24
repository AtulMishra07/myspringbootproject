package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CreditRating")
public class CreditRating implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="partner_id")
	private int partner_id;
	
	@Column(name="cif_nbr")
	private String cif_nbr;
	
	@Column(name="rating")
	private String rating;
	
	/**
	 * @return the partner_id
	 */
	public int getPartner_id() {
		return partner_id;
	}
	/**
	 * @param partner_id the partner_id to set
	 */
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	/**
	 * @return the cif_nbr
	 */
	public String getCif_nbr() {
		return cif_nbr;
	}
	/**
	 * @param cif_nbr the cif_nbr to set
	 */
	public void setCif_nbr(String cif_nbr) {
		this.cif_nbr = cif_nbr;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

}
