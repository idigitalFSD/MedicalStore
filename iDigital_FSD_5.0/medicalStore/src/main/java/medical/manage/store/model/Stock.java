package medical.manage.store.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@DynamicUpdate 
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
	
	@Column(name = "medicine_name")
	private String medicineName;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Manufacturer> manufacturer;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<MedicinePurchased> medicine;

	// Parameterized constructor
	public Stock(double costEach, int inStock, int sold, String medicineName, List<Manufacturer> manufacturer, List<MedicinePurchased> medicine) {
		super();
		this.costEach = costEach;
		this.inStock = inStock;
		this.sold = sold;
		this.medicineName = medicineName;
		this.manufacturer = manufacturer;
		this.medicine = medicine;
	}

	public Stock() {
		// TODO Auto-generated constructor stub
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

	public List<MedicinePurchased> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<MedicinePurchased> medicine) {
		this.medicine = medicine;
	}

	
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	
	// toString()
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", costEach=" + costEach + ", inStock=" + inStock + ", sold=" + sold
				+ ", medicineName=" + medicineName + ", manufacturer=" + manufacturer + ", medicine=" + medicine + "]";
	}


}


/*
 * package medical.manage.store.model;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.OneToMany;
 * 
 * import org.hibernate.annotations.DynamicUpdate;
 * 
 * import com.fasterxml.jackson.annotation.JsonIgnore;
 * 
 * @DynamicUpdate
 * 
 * @Entity(name = "stock") public class Stock {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO)
 * 
 * @Column(name = "stock_id") private int stockId;
 * 
 * @Column(name = "cost_each") private double costEach;
 * 
 * @Column(name = "in_stock") private int inStock;
 * 
 * @Column(name = "sold") private int sold;
 * 
 * @OneToMany(fetch = FetchType.LAZY)
 * 
 * @JsonIgnore private List<Manufacturer> manufacturer;
 * 
 * @OneToMany(fetch = FetchType.LAZY)
 * 
 * @JsonIgnore private List<MedicinePurchased> medicine;
 * 
 * // Parameterized constructor public Stock(double costEach, int inStock, int
 * sold, List<Manufacturer> manufacturer, List<MedicinePurchased> medicine) {
 * super(); this.costEach = costEach; this.inStock = inStock; this.sold = sold;
 * this.manufacturer = manufacturer; this.medicine = medicine; }
 * 
 * public Stock() { // TODO Auto-generated constructor stub }
 * 
 * // Getters and Setters public int getStockId() { return stockId; }
 * 
 * public void setStockId(int stockId) { this.stockId = stockId; }
 * 
 * public double getCostEach() { return costEach; }
 * 
 * public void setCostEach(double costEach) { this.costEach = costEach; }
 * 
 * public int getInStock() { return inStock; }
 * 
 * public void setInStock(int inStock) { this.inStock = inStock; }
 * 
 * public int getSold() { return sold; }
 * 
 * public void setSold(int sold) { this.sold = sold; }
 * 
 * public List<Manufacturer> getManufacturer() { return manufacturer; }
 * 
 * public void setManufacturer(List<Manufacturer> manufacturer) {
 * this.manufacturer = manufacturer; }
 * 
 * public List<MedicinePurchased> getMedicine() { return medicine; }
 * 
 * public void setMedicine(List<MedicinePurchased> medicine) { this.medicine =
 * medicine; }
 * 
 * // toString()
 * 
 * @Override public String toString() { return "Stock [stockId=" + stockId +
 * ", costEach=" + costEach + ", inStock=" + inStock + ", sold=" + sold +
 * ", manufacturer=" + manufacturer + ", medicine=" + medicine + "]"; }
 * 
 * }
 */