package cz.fi.muni.pa165.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Product {
	
	@Id
	private long id;
	
	@Lob
	private byte[] image;
	
	private double price;
	
	private String name;
	
	@Embedded
	private Size size;
	
	@Enumerated
	private Color color;
	
	public enum Color{ BLACK, WHITE, RED}
	
	@OneToMany(mappedBy="product")
	@OrderBy("created DESC")
	private List<ProductComment> comments = new ArrayList<ProductComment>();

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<ProductComment> getComments() {
		return comments;
	}

	public void addComment(ProductComment comment) {
		getComments().add(comment);
	}

	public long getId() {
		return id;
	}
	
}
