package medical.manage.store.service;

import java.util.List;

import medical.manage.store.model.Manufacturer;

public interface ManufacturerService {
	
	Manufacturer addManufacturer(Manufacturer manufacturer);

	List<Manufacturer> viewAllManufacturer();

	void deleteManufacturer(int id);

	Manufacturer updateManufacturerDetails(int id, Manufacturer manufacturer);

}
