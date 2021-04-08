package medical.manage.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException  {
	/**
	 * serialVersionId
	 */
	private static final long serialVersionUID = 1650819152211038986L;

	public ResourceNotFoundException(String message) {
		super(message);

	}
}
