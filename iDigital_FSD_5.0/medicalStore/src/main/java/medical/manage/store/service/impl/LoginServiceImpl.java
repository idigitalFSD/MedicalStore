package medical.manage.store.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.model.Registration;
import medical.manage.store.repository.LoginRepository;
import medical.manage.store.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
@Autowired
private LoginRepository repository;

//This method for validating userId is present or not
public Registration findByID(String userId) {
	Logger logger=Logger.getLogger(LoginServiceImpl.class);
	logger.info("entering services");
	return repository.findByID(userId);	
}
}