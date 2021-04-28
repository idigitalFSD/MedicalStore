package medical.manage.store.service;

import medical.manage.store.model.Registration;

public interface LoginService {

	public Registration findByID(String userId);

}
