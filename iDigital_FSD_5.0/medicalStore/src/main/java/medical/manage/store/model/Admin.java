package medical.manage.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import medical.manage.store.constants.MedicalStoreConstants;

@Entity(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private int adminId;

	@Pattern(regexp = MedicalStoreConstants.NAME_CHECK, message = MedicalStoreConstants.NAME_MESSAGE)
	@Column(name = "admin_name")
	private String adminName;

	@Pattern(regexp = MedicalStoreConstants.PASSWORD_CHECK, message = MedicalStoreConstants.PASSWORD_MESSAGE)
	@Column(name = "admin_password")
	private String adminPassword;

	// Parameterized constructor
	public Admin(
			@Pattern(regexp = "^([A-Za-z0-9 ]+)$", message = "Only Alphabets, numbers and spaces allowed !") String adminName,
			@Pattern(regexp = "^([A-Za-z0-9 ]+)$", message = "Please enter valid password !") String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	// Getters and setters
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	// toString()
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}

}
