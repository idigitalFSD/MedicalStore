package medical.manage.store.controller;

import java.util.List; 

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import medical.manage.store.exception.ResourceNotFoundException;
import medical.manage.store.model.Manufacturer;
import medical.manage.store.repository.ManufacturerRepository;
import medical.manage.store.service.ManufacturerService;

@Api(description="This is Manufacturer Controller Responsible for different "
		+ "database operations on manufacturer.")
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/manufacturer")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private ManufacturerRepository manufacturerRepo;
	
	// Save Manufacturer details

	@PostMapping(value = "/add_manufacturer")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("This will add manufacturers.")
	public ResponseEntity<String> registerManufacturer(@ApiParam("Need to provide manufacturer details.")
	@RequestBody Manufacturer manufacturer) {
		int id = manufacturerService.addManufacturer(manufacturer).getManufacturerId();

		return new ResponseEntity<String>("Manufacturer with ID " + id + 
				" added successfully.",
				HttpStatus.OK);
	}

	// View all Manufacturers

	  @GetMapping(value = "/view_all_manufacturers")
	  @ApiOperation("This will give all manufacturer's details in the form of list.") 
	  public List<Manufacturer> viewAllManufacturers() { return
	  manufacturerService.viewAllManufacturer(); }
	 

	// get Manufacturer by id rest api
	
		@GetMapping("/get_manufacturer_by_id/{id}")
		@ApiOperation("This will give manufacturer with the given ID.")
		public ResponseEntity<Manufacturer> getManufacturerById(@ApiParam("Need to provide "
				+ "manufacturer ID.")@PathVariable int id) {
			Manufacturer manufacturer = manufacturerRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Provided ID- :" + id+", is wrong. "
							+ "Please enter correct ID."));
			return ResponseEntity.ok(manufacturer);
		}
		
	// Delete Manufacturer

	@DeleteMapping(value = "/delete_manufacturer/{id}")
	@ApiOperation("This will delete manufacturer with the provided ID.")
	public ResponseEntity<String> deleteManufacturer(@ApiParam("Need to provide "
			+ "manufacturer ID.")@PathVariable int id) {
		manufacturerService.deleteManufacturer(id);
		return new ResponseEntity<String>("Manufacturer with ID- " 
		+ id + " deleted.", HttpStatus.OK);
	}

	// Updating Manufacturer information

	@PutMapping(value = "/update_manufacturer/{id}")
	@ApiOperation("This will update manufacturer details.")
	public ResponseEntity<String> updateManufacturerDetails(@ApiParam("Need to provide "
			+ "manufacturer ID.")@PathVariable int id, 
			@ApiParam("Need to provide manufacturer details.")@RequestBody Manufacturer manufacturer) {
		manufacturerService.updateManufacturerDetails(id, manufacturer);
		return new ResponseEntity<String>("Manufacturer's information updated successfully.", 
				HttpStatus.OK);
	}

}
