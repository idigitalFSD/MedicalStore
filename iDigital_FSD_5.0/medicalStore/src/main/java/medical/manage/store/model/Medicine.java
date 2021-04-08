package medical.manage.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "medicine_id")
	private int medicineId;

	@Column(name = "medicine_name")
	private String medicineName;

	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor
	public Medicine(String medicineName) {
		super();
		this.medicineName = medicineName;
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

	// toString()
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + "]";
	}

}
