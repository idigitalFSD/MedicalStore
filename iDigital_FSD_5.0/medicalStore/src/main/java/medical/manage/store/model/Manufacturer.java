package medical.manage.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import medical.manage.store.constants.MedicalStoreConstants;

@Entity(name = "manufacturer")
@ApiModel(description="This is Manufacturer model which representd database table.")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", initialValue=10001, allocationSize=1)
	@ApiModelProperty(notes = "The Id value of manufacturer")
	@Column(name = "manufacturer_id")
	private int manufacturerId;

	@ApiModelProperty(notes = "The name of manufacturer")
	@Column(name = "manufacturer_name")
	private String manufacturerName;

	@Pattern(regexp = MedicalStoreConstants.LICENCE_CHECK, message = MedicalStoreConstants.LICENCE_MESSAGE)
	@ApiModelProperty(notes = "The manufacturing license number of manufacturer")
	@Column(name = "mfgLicence")
	private String mfgLicence;

	@ApiModelProperty(notes = "The address of manufacturer")
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