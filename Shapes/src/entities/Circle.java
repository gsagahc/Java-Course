package entities;

import java.text.DecimalFormat;

import entities.enums.Color;

public class Circle extends Shape{
	private Double radius;
	DecimalFormat df = new DecimalFormat("#,###.00");
	public Circle() {
		super();
	}
	

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}


	public Double getRadius() {
		return radius;
	}


	public void setRadius(Double radius) {
		this.radius = radius;
	}


	@Override
	public Double area() {
		return Math.PI * radius * radius;
	}
	@Override
	public String toString() {
		return df.format(area());
		
	}

}
