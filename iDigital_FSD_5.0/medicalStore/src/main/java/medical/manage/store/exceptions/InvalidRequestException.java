package medical.manage.store.exceptions;

public class InvalidRequestException extends RuntimeException  {
	/**
	 * serialVersionId
	 */
	private static final long serialVersionUID = 1650819152211038986L;

	public InvalidRequestException (String message) {
		super(message);

	}
}