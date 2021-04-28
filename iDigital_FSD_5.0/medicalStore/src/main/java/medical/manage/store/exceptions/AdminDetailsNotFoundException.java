package medical.manage.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdminDetailsNotFoundException extends RuntimeException
{
	public AdminDetailsNotFoundException() {
		
	}
	 public AdminDetailsNotFoundException(Long adminId) 
	{
        super("AdminToAdmin id not found : " + adminId);
	}
 
}
