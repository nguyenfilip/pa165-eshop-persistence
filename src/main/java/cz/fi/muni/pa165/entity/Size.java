package cz.fi.muni.pa165.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Size {
	private Integer length;
	private Integer width;
	private Integer height;
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
}
