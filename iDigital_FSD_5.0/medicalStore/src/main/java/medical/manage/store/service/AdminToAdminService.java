package medical.manage.store.service;

import java.util.List;
import java.util.Optional;

import medical.manage.store.model.AdminToAdmin;

public interface AdminToAdminService {
	public List<AdminToAdmin> getAllAdminDetails();

	public AdminToAdmin createNewAdmin(AdminToAdmin newAdmin);

	public AdminToAdmin updateOrSaveAdminDetails(AdminToAdmin updateAdminDetails, Long adminId);

	public Optional<AdminToAdmin> findById(Long adminId); // ici2020not095156

	public List<AdminToAdmin> deleteAdminByadminId(Long adminId);
}
