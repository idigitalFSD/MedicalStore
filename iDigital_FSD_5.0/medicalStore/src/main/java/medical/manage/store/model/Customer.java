package medical.manage.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import medical.manage.store.constants.MedicalStoreConstants;

@Entity(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int custId;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_gender")
	private String custGender;

	@Column(name = "cust_city")
	private String custCity;

	@Column(name = "cust_age")
	private int custAge;

	@Column(name = "cust_phone_no")
	@Pattern(regexp = MedicalStoreConstants.MOBNO_CHECK, message = MedicalStoreConstants.MOBNO_MESSAGE)
	private String custPhoneNum;

	public Customer() {
		super();
	}

	public Customer(int custId, String custName, String custGender, String custCity, int custAge,
			@Pattern(regexp = "^([7-9][0-9]{9})$", message = "10 digit Mobile phone number is required!") String custPhoneNum) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custGender = custGender;
		this.custCity = custCity;
		this.custAge = custAge;
		this.custPhoneNum = custPhoneNum;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public String getCustPhoneNum() {
		return custPhoneNum;
	}

	public void setCustPhoneNum(String custPhoneNum) {
		this.custPhoneNum = custPhoneNum;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custGender=" + custGender + ", custCity="
				+ custCity + ", custAge=" + custAge + ", custPhoneNum=" + custPhoneNum + "]";
	}
}
