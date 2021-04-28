package medical.manage.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.exceptions.NoAdminFoundByGivenId;
import medical.manage.store.model.AdminToAdmin;
import medical.manage.store.repository.AdminToAdminRepository;
import medical.manage.store.service.AdminToAdminService;

@Service
public class AdminToAdminServiceImpl implements AdminToAdminService{
	@Autowired
	private AdminToAdminRepository adminToAdminRepository;
	@Override
	public List<AdminToAdmin> getAllAdminDetails()
	{
		List<AdminToAdmin> adminDetails = (List<AdminToAdmin>) adminToAdminRepository.findAll();
		return  adminDetails;
	}
	
	@Override
	public AdminToAdmin createNewAdmin(AdminToAdmin newAdmin)
	{
		return adminToAdminRepository.save(newAdmin);
	}
	
	@Override
	public AdminToAdmin updateOrSaveAdminDetails(AdminToAdmin updateAdminDetails, Long adminId)
	{
		return adminToAdminRepository.findById(adminId).
				map(adminDetails ->{
					adminDetails.setAdminName(updateAdminDetails.getAdminName());
					adminDetails.setAdminAge(updateAdminDetails.getAdminAge());
					adminDetails.setAdminJoiningDate(updateAdminDetails.getAdminJoiningDate());
					adminDetails.setAdminPassword(updateAdminDetails.getAdminPassword());
					adminDetails.setAdminPhoneNum(updateAdminDetails.getAdminPhoneNum());
				return adminToAdminRepository.save(updateAdminDetails);
				}).orElseGet(()->{
					return adminToAdminRepository.save(updateAdminDetails);
				});
		
	}
	@Override
	public Optional<AdminToAdmin> findById(Long adminId){
		AdminToAdmin adminDetails = adminToAdminRepository.findById(adminId)
				.orElseThrow(() -> new NoAdminFoundByGivenId("No such job with id " + adminId));
		return adminToAdminRepository.findById(adminId);
	
	}
@Override
	public List<AdminToAdmin> deleteAdminByadminId(Long adminId){
		AdminToAdmin adminDetails = adminToAdminRepository.findById(adminId)
				.orElseThrow(() -> new NoAdminFoundByGivenId("No such job with id " + adminId));
		adminToAdminRepository.deleteById(adminDetails.getAdminId());
		return (List<AdminToAdmin>) adminToAdminRepository.findAll();
	}
	}


