package carDealership;

public class Car extends Vehicle{
	private String type;
	
	public Car(String make, String model, String color, int year, double price, String type) {
		super(make, model, color, year, price);
		this.type = type;
	}
	
	public Car(Car c) {
		this(c.make, c.model, c.color, c.year, c.price, c.type);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void displayInfo() {
		String carName = make + " " + model + " " + year;
		System.out.println("ID: " + id);
        System.out.println("Car: " + carName);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
        System.out.println("Price: " + price + " SAR");
	}
	
public String toString() {
		
		return super.toString() + "\nType: " +type;
	}
	
	
	
	
}
