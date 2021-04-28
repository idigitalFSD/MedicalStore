   package medical.manage.store.model;
   import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.Pattern;
	import javax.validation.constraints.Size;

	import javax.validation.constraints.NotNull;
      
	@Entity
	@Table()
public class AdminToAdmin {
		public AdminToAdmin() {
			
		}
		@Id   
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long adminId;
		@NotNull
		@Size(min = 3, message = " Name length should be greater than 2")
		private String adminName;
		@NotNull
		@Size(min = 1, max = 2, message = "Please Enter Valid age of length 2 digits")
		@Pattern(regexp = "[0-9]+")
		private String adminAge;
		@NotNull
		private String adminJoiningDate;
		@NotNull
		@Size(min = 5, message = "Password Length Should be more then 5")
		@Pattern(regexp = "[A-Za-z0-9]+[!@#$%^&*]+[a-zA-Z0-9]*", message = "Password Should Contain UpperCase or LowerCase Alphabet, special character and digits")
		private String adminPassword;
		@NotNull
	@Size(min = 10, max = 10, message = "Please Enter Valid Phone Number of length 10 digits")
	@Pattern(regexp = "[0-9]+")
		private String adminPhoneNum;
		
		public AdminToAdmin(Long adminId,
				@NotNull @Size(min = 3, message = " Name length should be greater than 2") @Pattern(regexp = "[_a-zA-Z]+[0-9]*", message = "Please use alphabet or alphanumeric combination") String adminName,
				@NotNull @Size(min = 1, max = 2, message = "Please Enter Valid age of length 2 digits") @Pattern(regexp = "[0-9]+") String adminAge,
				String adminJoiningDate,
				@NotNull @Size(min = 5, message = "Password Length Should be more then 5") @Pattern(regexp = "[A-Za-z0-9]+[!@#$%^&*]+[a-zA-Z0-9]*", message = "Password Should Contain UpperCase or LowerCase Alphabet, special character and digits") String adminPassword,
				@NotNull @Size(min = 10, max = 10, message = "Please Enter Valid Phone Number of length 10 digits") @Pattern(regexp = "[0-9]+") String adminPhoneNum) {
			super();
			this.adminId = adminId;
			this.adminName = adminName;
			this.adminAge = adminAge;
			this.adminJoiningDate = adminJoiningDate;
			this.adminPassword = adminPassword;
			this.adminPhoneNum = adminPhoneNum;
		}
		public AdminToAdmin(String adminName, String adminAge, String adminJoiningDate, String adminPassword,
				String adminPhoneNum) {
			super();
			this.adminName = adminName;
			this.adminAge = adminAge;
			this.adminJoiningDate = adminJoiningDate;
			this.adminPassword = adminPassword;
			this.adminPhoneNum = adminPhoneNum;
		}
		public Long getAdminId() {
			return adminId;
		}
		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getAdminAge() {
			return adminAge;
		}
		public void setAdminAge(String adminAge) {
			this.adminAge = adminAge;
		}
		public String getAdminJoiningDate() {
			return adminJoiningDate;
		}
		public void setAdminJoiningDate(String adminJoiningDate) {
			this.adminJoiningDate = adminJoiningDate;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		public String getAdminPhoneNum() {
			return adminPhoneNum;
		}
		public void setAdminPhoneNum(String adminPhoneNum) {
			this.adminPhoneNum = adminPhoneNum;
		}
		
}
