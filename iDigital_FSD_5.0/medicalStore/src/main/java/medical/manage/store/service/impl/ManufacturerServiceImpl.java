package medical.manage.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.model.Manufacturer;
import medical.manage.store.repository.ManufacturerRepository;
import medical.manage.store.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepo;
	
	// Adding a manufacturer
	
	@Override
	public Manufacturer addManufacturer(Manufacturer manufacturer) {
		return manufacturerRepo.save(manufacturer);
	}

	// View list of manufacturer
	
	@Override
	public List<Manufacturer> viewAllManufacturer() {
		return manufacturerRepo.findAll();
	}

	// Delete a manufacturer
	
	@Override
	public void deleteManufacturer(int id) {
		Manufacturer manufacturer=manufacturerRepo.findByManufacturerId(id);
		manufacturerRepo.deleteById(manufacturer.getManufacturerId());;
	}
	
	// Update manufacturer

	@Override
	public Manufacturer updateManufacturerDetails(Manufacturer manufacturer) {
		if(manufacturerRepo.existsById(manufacturer.getManufacturerId())) {
			return manufacturerRepo.saveAndFlush(manufacturer);
		}
		else {
			throw new ResourceNotFoundException("Manufacturer not found with given Id");
		}
	}

//	@Override
//	public Manufacturer updateManufacturerDetails(int id, Manufacturer manufacturer) {
//		Optional<Manufacturer> studOptional = manufacturerRepo.findById(id);
//		if (!studOptional.isPresent())
//			throw new ResourceNotFoundException("Provided ID- :" + id+", is wrong. "
//					+ "Please enter correct ID.");
//		else {
//			manufacturer.setManufacturerId(id);
//			manufacturer.setManufacturerName(manufacturer.getManufacturerName());
//			manufacturer.setMfgLicence(manufacturer.getMfgLicence());
//			manufacturer.setAddress(manufacturer.getAddress());
//		}
//		return manufacturerRepo.save(manufacturer);
//	}

}
