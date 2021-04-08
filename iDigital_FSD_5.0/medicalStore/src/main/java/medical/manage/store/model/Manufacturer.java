package medical.manage.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Pattern;

import medical.manage.store.constants.MedicalStoreConstants;

@Entity(name = "manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", initialValue=10001, allocationSize=1)
	@Column(name = "manufacturer_id")
	private int manufacturerId;

	@Column(name = "manufacturer_name")
	private String manufacturerName;

	@Pattern(regexp = MedicalStoreConstants.LICENCE_CHECK, message = MedicalStoreConstants.LICENCE_MESSAGE)
	@Column(name = "mfgLicence")
	private String mfgLicence;

	@Column(name = "address")
	private String address;

	public Manufacturer() {
		super();
	}

	// Parameterized Constructor
	public Manufacturer(String manufacturerName,
			@Pattern(regexp = "[A-Za-z]{3}[0-9]{7}", message = "Invalid licence number !") String mfgLicence,
			String address) {
		super();
		this.manufacturerName = manufacturerName;
		this.mfgLicence = mfgLicence;
		this.address = address;
	}

	// Getters and Setters
	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getMfgLicence() {
		return mfgLicence;
	}

	public void setMfgLicence(String mfgLicence) {
		this.mfgLicence = mfgLicence;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// toString()
	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", mfgLicence=" + mfgLicence + ", address=" + address + "]";
	}
}
/*
 * package medical.manage.store.entity;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.SequenceGenerator;
 * import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="manufacturer") public class Manufacturer {
 * 
 * @Id
 * 
 * @Column(name = "id")
 * 
 * @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
 * 
 * @SequenceGenerator(name="seq", initialValue=10001, allocationSize=1) private
 * int mId;
 * 
 * @Column(name = "name") private String mName;
 * 
 * @Column(name = "mfg_licence") private String mfgLicence; private String
 * address;
 * 
 * public int getmId() { return mId; } public void setmId(int mId) { this.mId =
 * mId; } public String getmName() { return mName; } public void setmName(String
 * mName) { this.mName = mName; } public String getMfgLicence() { return
 * mfgLicence; } public void setMfgLicence(String mfgLicence) { this.mfgLicence
 * = mfgLicence; } public String getAddress() { return address; } public void
 * setAddress(String address) { this.address = address; } public Manufacturer()
 * { super(); } public Manufacturer(String mName, String mfgLicence, String
 * address) { super(); this.mName = mName; this.mfgLicence = mfgLicence;
 * this.address = address; }
 * 
 * }
 */