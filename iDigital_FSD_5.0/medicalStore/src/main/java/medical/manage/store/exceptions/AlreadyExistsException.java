package medical.manage.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
public class AlreadyExistsException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5963894319534779178L;

	public AlreadyExistsException(String message) {
		super(message);
	}
	
}
