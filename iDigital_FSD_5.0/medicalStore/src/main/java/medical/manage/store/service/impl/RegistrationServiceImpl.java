package medical.manage.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.model.Registration;
import medical.manage.store.repository.RegistrationRepository;
import medical.manage.store.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{
@Autowired
private RegistrationRepository repo;
	@Override
	public Registration createdata(Registration data) {
		
		return repo.save(data);
	}

}
