package medical.manage.store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.exceptions.UserValidate;
import medical.manage.store.model.Registration;
import medical.manage.store.service.RegistrationService;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private  RegistrationService registrationService;

  

    @PostMapping("/userRegistration/createUserDetails")
    public Registration createdata(@RequestBody Registration data) throws ResourceNotFoundException{
    	UserValidate vali=new UserValidate();
    	Registration data1;
    	boolean v=vali.validateUser(data.getUserId());
    boolean v1=	vali.validatePassword(data.getPassword());
    if(data.getUserId().equals("") || data.getPassword().equals("") || data.getEmailId().equals(""))
	{
		throw new ResourceNotFoundException("Enter Valid Data");
	}
    if(v)
    { 
    	if(v1)
    	{
    		 data1= registrationService.createdata(data);
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Enter Valid Password ");
    	}
    }else
    {
    	throw new ResourceNotFoundException("Enter Valid UserId ");
    }
        return data1;
    }

}

/*
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import medical.manage.store.exceptions.ResourceNotFoundException; import
 * medical.manage.store.exceptions.UserValidate; import
 * medical.manage.store.model.Registration; import
 * medical.manage.store.service.RegistrationService;
 * 
 * @CrossOrigin
 * 
 * @RestController
 * 
 * @RequestMapping("/api/v1/medicalstore/userRegistration") public class
 * RegistrationController {
 * 
 * @Autowired private RegistrationService registrationService;
 * 
 * 
 * 
 * @PostMapping("/createUserDetails") public Registration
 * createdata(@RequestBody Registration data) throws ResourceNotFoundException{
 * UserValidate vali=new UserValidate(); Registration data1; boolean
 * v=vali.validateUser(data.getUserId()); boolean v1=
 * vali.validatePassword(data.getPassword()); if(data.getUserId().equals("") ||
 * data.getPassword().equals("") || data.getEmailId().equals("")) { throw new
 * ResourceNotFoundException("Enter Valid Data"); } if(v) { if(v1) { data1=
 * registrationService.createdata(data); } else { throw new
 * ResourceNotFoundException("Enter Valid Password "); } }else { throw new
 * ResourceNotFoundException("Enter Valid UserId "); } return data1; }
 * 
 * }
 * 
 */