package medical.manage.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.constants.MedicalStoreConstants;
import medical.manage.store.exceptions.AlreadyExistsException;
import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.model.Manufacturer;
import medical.manage.store.model.MedicinePurchased;
import medical.manage.store.repository.MedicinePurchasedRepository;
import medical.manage.store.service.MedicinePurchasedService;

@Service
public class MedicinePurchasedServiceImpl implements MedicinePurchasedService {

	@Autowired
	private MedicinePurchasedRepository medicineRepository;

	/**
	 * Adds medicine to medicine table
	 * 
	 * @return medicineCreation
	 */

	@Override
	public MedicinePurchased addMedicine(MedicinePurchased purchase) {
		return medicineRepository.save(purchase);
	}

	/**
	 * Get all Medicine method
	 * 
	 * @return allMedicine
	 */

	@Override
	public List<MedicinePurchased> getAllMedicine() {
		List<MedicinePurchased> allMedicine = medicineRepository.findAll();
		if (allMedicine.isEmpty())
			throw new ResourceNotFoundException(MedicalStoreConstants.NOT_FOUND);

		return allMedicine;
	}

	/**
	 * Get medicines by medicineName method
	 * 
	 * @return medicine
	 */
	@Override
	public MedicinePurchased getByMedicineName(String medicineName) {
		Optional<MedicinePurchased> optionalMedicine = medicineRepository.findByMedicineName(medicineName);
		MedicinePurchased medicine = new MedicinePurchased();

		if (!optionalMedicine.isPresent()) {
			throw new ResourceNotFoundException(MedicalStoreConstants.NOT_FOUND);
		} else {

			medicine.setMedicineId(optionalMedicine.get().getMedicineId());
			medicine.setMedicineName(medicineName);

			medicineRepository.save(medicine);

			return medicine;
		}
	}

	/**
	 * Get medicines by Id method
	 * 
	 * @return medicine
	 */
	@Override
	public MedicinePurchased getById(int medicineId) {
		Optional<MedicinePurchased> optionalMedicine = medicineRepository.findById(medicineId);
		MedicinePurchased medicine = new MedicinePurchased();
		if (!optionalMedicine.isPresent()) {
			throw new ResourceNotFoundException(MedicalStoreConstants.NOT_FOUND);
		} else {

			medicine.setMedicineId(medicineId);
			medicine.setMedicineName(optionalMedicine.get().getMedicineName());
			medicineRepository.save(medicine);

			return medicine;
		}
	}

	/**
	 * Remove medicines by Id method
	 * 
	 * @return void
	 */
	@Override
	public String removeById(int medicinesId) {
		Optional<MedicinePurchased> optionalMedicine = medicineRepository.findById(medicinesId);
		if (!optionalMedicine.isPresent()) {
			throw new ResourceNotFoundException(MedicalStoreConstants.NOT_FOUND);
		} else {
			medicineRepository.deleteById(medicinesId);
			return "Medicine is deleted!";
		}
	}

	/**
	 * Remove medicines by medicineName method
	 * 
	 * @return void
	 */
	@Override
	public String removeByMedicineName(String medicineName) {
		Optional<MedicinePurchased> optionalMedicine = medicineRepository.findByMedicineName(medicineName);
		if (!optionalMedicine.isPresent()) {
			throw new ResourceNotFoundException(MedicalStoreConstants.NOT_FOUND);
		} else {
			medicineRepository.deleteByMedicineName(medicineName);
			return "User is deleted!";
		}
	}

	/**
	 * Modify medicine method
	 * 
	 * @return medicineModified
	 */
	@Override
	public MedicinePurchased modifyMedicine(MedicinePurchased medicine) {
		Optional<MedicinePurchased> optionalMedicine = medicineRepository.findByMedicineName(medicine.getMedicineName());

		MedicinePurchased newMedicine = new MedicinePurchased();
		if (!optionalMedicine.isPresent()) {
			throw new ResourceNotFoundException(MedicalStoreConstants.NOT_FOUND);
		} else {
			newMedicine.setMedicineId(optionalMedicine.get().getMedicineId());
			newMedicine.setMedicineName(optionalMedicine.get().getMedicineName());
			medicineRepository.save(newMedicine);
		}

		return newMedicine;
	}

}
