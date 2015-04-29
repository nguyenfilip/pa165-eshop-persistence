package cz.fi.muni.pa165.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class ProductComment {
	@Id
	private long id;
	
	@ManyToOne(optional=false)
	private User user;
	
	@ManyToOne(optional=false)
	private Product product;
	
	private String text;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	private int starsRating;

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getStarsRating() {
		return starsRating;
	}

	public void setStarsRating(int starsRating) {
		this.starsRating = starsRating;
	}

	public long getId() {
		return id;
	}
}
