package medical.manage.store.exceptions;

import java.util.Date;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import medical.manage.store.utils.ExceptionResponse;

@EnableWebMvc
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{
	
	// MethodArgumentNotValisException
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), new Date(),ex.getMessage()
					, request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}

		// RequestMethodNotSupported
		@Override
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), new Date(),
					"Method not supported!", request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.METHOD_NOT_ALLOWED);
		}

		/**
		 * Duplicate record finding exception
		 * 
		 * @param ex      AlreadyExistsException
		 * @param request currentRequest
		 * @return an exception if record already exists.
		 */
		@ExceptionHandler(AlreadyExistsException.class)
		protected ResponseEntity<Object> handleAlreadyExistException(AlreadyExistsException ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(),
					ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		/**
		 * Resource not found exception
		 * 
		 * @param ex      ResourceNotFoundException
		 * @param request currentRequest
		 * @return an exception if record does not exists.
		 */
		@ExceptionHandler(ResourceNotFoundException.class)
		protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
					ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
		}

		/**
		 * Request not valid exception
		 * 
		 * @param ex      InvalidRequestException
		 * @param request currentRequest
		 * @return an exception if request is invalid.
		 */
		@ExceptionHandler(InvalidRequestException.class)
		protected ResponseEntity<Object> handleInvalidException(InvalidRequestException ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), new Date(),
					ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}

		@ExceptionHandler(value = { Exception.class })
		public ResponseEntity<Object> handleAnyRequest(Exception ex, WebRequest request) {
			String errorDescription = ex.getLocalizedMessage();

			if (errorDescription == null) {
				errorDescription = ex.toString();
			}

			ErrorMessage errorMessage = new ErrorMessage(errorDescription, new Date(),request.getDescription(false));

			return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		@ExceptionHandler(value = { NullPointerException.class })
		public ResponseEntity<Object> handleNullpointerException(NullPointerException ex, WebRequest request) {
			String errorDescription = ex.getLocalizedMessage();

			if (errorDescription == null) {
				errorDescription = ex.toString();
			}

			ErrorMessage errorMessage = new ErrorMessage(errorDescription, new Date(),request.getDescription(false));

			return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
}
