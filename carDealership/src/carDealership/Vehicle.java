package carDealership;

import java.io.Serializable;

public abstract class Vehicle implements Serializable{
	protected String make, model, color;
	protected int year;
	protected double price;
	protected int id;
	//private static int nextId;
	
	public Vehicle(String make, String model, String color, int year, double price) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		setPrice(price);
	}
	
	public abstract void displayInfo();
	
	
	public String toString() {
		
		return "ID: " + id +"\nMake: " +make + "\nModel: "+ model+ "\nColor: "+ color +"\nYear: "+year +"\nPrice: "+ price ;
	}
	
	

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price<0) {
			price = 0;
		}
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
