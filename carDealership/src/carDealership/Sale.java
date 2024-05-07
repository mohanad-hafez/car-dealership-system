package carDealership;
import java.io.Serializable;
import java.time.LocalDate;

public class Sale implements Serializable{
	private Vehicle vehicle;
	private String buyerName;
	private String buyerContact;
	private LocalDate saleDate;
	
	public Sale(Vehicle vehicle, String buyerName, String buyerContact, LocalDate saleDate) {
		this.vehicle = vehicle;
		this.buyerName = buyerName;
		this.buyerContact = buyerContact;
		this.saleDate = saleDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerContact() {
		return buyerContact;
	}

	public void setBuyerContact(String buyerContact) {
		this.buyerContact = buyerContact;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	
	
	
	
}
