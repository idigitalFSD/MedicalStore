package medical.manage.store.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity(name = "medicine")
@ApiModel(description="This is Medicine model to create a table that keeps a record of names of all medicines in database.")
public class MedicinePurchased {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The Id value of medicine")
	@Column(name = "medicine_id")
	private int medicineId;

	@ApiModelProperty(notes = "The name of medicine")
	@Column(name = "medicine_name")
	private String medicineName;
	
	@ApiModelProperty(notes = "Quantity of medicines ")
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturerId")
	private Manufacturer manufacturer;

	
	public MedicinePurchased() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor
	public MedicinePurchased(String medicineName, int quantity) {
		super();
		this.medicineName = medicineName;
		this.quantity = quantity;
	}

	// Getters and Setters
	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	// toString()
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + "]";
	}

}
