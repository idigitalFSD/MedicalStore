package medicalStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import medicalStore.constants.MedicalStoreConstants;

@Entity(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private int adminId;

	@Pattern(regexp= MedicalStoreConstants.NAME_CHECK, message = MedicalStoreConstants.NAME_MESSAGE )
	@Column(name="admin_name")
	private String adminName;
	
	@Pattern(regexp= MedicalStoreConstants.PASSWORD_CHECK, message = MedicalStoreConstants.PASSWORD_MESSAGE )
	@Column(name="admin_password")
	private String adminPassword;
	
}
