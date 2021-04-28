package medical.manage.store.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import medical.manage.store.exceptions.AdminDetailsNotFoundException;
import medical.manage.store.model.AdminToAdmin;
import medical.manage.store.repository.AdminToAdminRepository;
import medical.manage.store.service.AdminToAdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/medicalstore/")
public class AdminToAdminController {

	@Autowired
	private AdminToAdminService adminService;
	
	@Autowired
	private AdminToAdminRepository adminToAdminRepository;
	
	
	@GetMapping("/adminDetails")
	public ResponseEntity<List<AdminToAdmin>> getAllAdminDetails()

	{
		List<AdminToAdmin> adminDetails = adminService.getAllAdminDetails();
		if(!adminDetails.isEmpty()) 
		{
			return new ResponseEntity<List<AdminToAdmin>>(adminDetails, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<AdminToAdmin>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@PostMapping("/adminDetails/registration")
	public @ResponseBody ResponseEntity<AdminToAdmin> createNewAdmin( @Valid @RequestBody AdminToAdmin newAdmin) 
	{
		AdminToAdmin ad = adminService.createNewAdmin(newAdmin);
	    return new ResponseEntity<AdminToAdmin>(ad, HttpStatus.CREATED);
	}
	

	@PutMapping("/adminDetails/updateProfile/{adminId}")
	public ResponseEntity<AdminToAdmin> updateOrSaveAdminDetails( @Valid @RequestBody AdminToAdmin updateAdminDetails, @PathVariable Long adminId) 
	{
		if(adminToAdminRepository.findById(updateAdminDetails.getAdminId()).isPresent())
		{
			AdminToAdmin ad = adminService.updateOrSaveAdminDetails(updateAdminDetails, adminId);
			return new ResponseEntity<AdminToAdmin>(ad, HttpStatus.OK);
		}
		else
		{
			new AdminDetailsNotFoundException(adminId);
			return new ResponseEntity<AdminToAdmin>(updateAdminDetails, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/adminDetails/{adminId}")
	public Object getAdminDetailsById(@PathVariable Long adminId) {

		Object adminDetails =adminService.findById(adminId);
		return ResponseEntity.ok(adminDetails);
	}
	@DeleteMapping(value = "adminDetails/deleteadmin/{adminId}")
	public ResponseEntity<List<AdminToAdmin>> deleteAdminByadminId(@PathVariable   Long adminId){
		List<AdminToAdmin> adminDetails = adminService.deleteAdminByadminId(adminId);
		return new ResponseEntity<List<AdminToAdmin>>(adminDetails, HttpStatus.OK);	}

}

