package medical.manage.store.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.exceptions.UserValidate;
import medical.manage.store.model.Registration;
import medical.manage.store.service.LoginService;

@CrossOrigin
@RestController
	@RequestMapping("/api/v1")
	public class LoginController {
		// creating varibl
	private	static Registration data; //static data
		
		@Autowired
		private LoginService service;
		
		/*
		 * This get Method for checking userId,password
		 */
		@GetMapping("/Login1/{userId}/{password}")
		public ResponseEntity<String> validateUser(@PathVariable(value = "userId") String userId,@PathVariable(value="password") String password)
				throws ResourceNotFoundException {
			
			UserValidate validate=new UserValidate();
			boolean userValidate=validate.validateUser(userId);
			boolean passwordValidate=validate.validatePassword(password); //validating password
			if(userValidate )
			{
				if(passwordValidate)
				{
			Logger logger=Logger.getLogger(Registration.class);
				data =  service.findByID(userId);
				
				logger.info("ending services");
				logger.debug("running");
						
				if(data!=null)
				{
				if(data.getPassword().equals(password) && data.getUserId().equals(userId))
				{
					logger.info("sucess");
					
					
					
					return ResponseEntity.ok().body("sucess login");
				}
				}else
				{
					throw new ResourceNotFoundException("Employee not found for this id :: " + userId);
					}
			
			return ResponseEntity.ok().body("invalid login");
		}else 
		{
			if(password.substring(0,6).equals(userId.subSequence(0,6)))
			{
				return ResponseEntity.ok().body("invalid user Id do not match with userName ");
			}
			else { 
		return ResponseEntity.ok().body("invalid Password Must contain atleast one special character");
		}
			}
			}
			else {
				
			return ResponseEntity.ok().body("invalid userId Enter Valid userId 7 ");
			}
	}


}
