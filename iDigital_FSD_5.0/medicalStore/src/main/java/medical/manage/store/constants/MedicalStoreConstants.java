package medical.manage.store.constants;

public class MedicalStoreConstants {

	// Regex patterns
	public static final String NAME_CHECK = "^([A-Za-z0-9 ]+)$";
	public static final String PASSWORD_CHECK = "^([A-Za-z0-9 ]+)$"; // update with correct regex
	public static final String LICENCE_CHECK = "[A-Za-z]{3}[0-9]{7}";
	public static final String MOBNO_CHECK = "^([7-9][0-9]{9})$";

	// Validation messages
	public static final String NAME_MESSAGE = "Only Alphabets, numbers and spaces allowed !";
	public static final String PASSWORD_MESSAGE = "Please enter valid password !";
	public static final String LICENCE_MESSAGE = "Invalid licence number !";
	public static final String ALREADY_EXISTS = "Element already exists !";
	public static final String NOT_FOUND = "Element not found !";
	public static final String WELCOME_MESSAGE = "Welcome to the STORE MANAGEMENT";
	public static final String MOBNO_MESSAGE = "10 digit Mobile phone number is required!";

	// Exception message
	public static final String CUSTOMER_EXISTS = "Customer already exists!";
	public static final String CUSTOMER_NOT_FOUND = "Customer not found in Customer repository!";

}
