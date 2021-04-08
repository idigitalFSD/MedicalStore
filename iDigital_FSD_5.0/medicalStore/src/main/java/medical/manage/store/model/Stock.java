package medical.manage.store.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_id")
	private int stockId;

	@Column(name = "cost_each")
	private double costEach;

	@Column(name = "in_stock")
	private int inStock;

	@Column(name = "sold")
	private int sold;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Manufacturer> manufacturer;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Medicine> medicine;

	// Parameterized constructor
	public Stock(double costEach, int inStock, int sold, List<Manufacturer> manufacturer, List<Medicine> medicine) {
		super();
		this.costEach = costEach;
		this.inStock = inStock;
		this.sold = sold;
		this.manufacturer = manufacturer;
		this.medicine = medicine;
	}

	// Getters and Setters
	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public double getCostEach() {
		return costEach;
	}

	public void setCostEach(double costEach) {
		this.costEach = costEach;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public List<Manufacturer> getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(List<Manufacturer> manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}

	// toString()
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", costEach=" + costEach + ", inStock=" + inStock + ", sold=" + sold
				+ ", manufacturer=" + manufacturer + ", medicine=" + medicine + "]";
	}

}
