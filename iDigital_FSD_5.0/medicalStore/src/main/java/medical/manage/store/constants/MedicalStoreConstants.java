package medical.manage.store.constants;

public class MedicalStoreConstants {
	
	// Regex patterns
		public static final String NAME_CHECK="^([A-Za-z0-9 ]+)$";
		public static final String PASSWORD_CHECK="^([A-Za-z0-9 ]+)$"; // update with correct regex
		public static final String LICENCE_CHECK = "[A-Za-z]{3}[0-9]{7}";
		
		// Validation messages
		public static final String NAME_MESSAGE="Only Alphabets, numbers and spaces allowed !";
		public static final String PASSWORD_MESSAGE="Please enter valid password !";
		public static final String LICENCE_MESSAGE="Invalid licence number !";
		

}
