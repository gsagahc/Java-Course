package entities;

import java.text.DecimalFormat;

import entities.enums.Color;

public class Rectangle extends Shape{
	private Double width;
	private Double height;
	DecimalFormat df = new DecimalFormat("#,###.00");
	public Rectangle() {
		super();
	}
	

	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}


	public Double getWidth() {
		return width;
	}


	public void setWidth(Double width) {
		this.width = width;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	@Override
	public Double area() {
		return width * height;
	
	}
	@Override
	public String toString() {
		return df.format(area());
		
	}

}
