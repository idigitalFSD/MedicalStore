package medical.manage.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medical.manage.store.constants.MedicalStoreConstants;
import medical.manage.store.exceptions.AlreadyExistsException;
import medical.manage.store.exceptions.ResourceNotFoundException;
import medical.manage.store.model.Medicine;
import medical.manage.store.repository.MedicineRepository;
import medical.manage.store.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	/**
	 * Adds medicine to medicine table
	 * 
	 * @return medicineCreation
	 */

	@Override
	public Medicine addMedicine(Medicine medicine) {
		String name = medicine.getMedicineName();
		Optional<Medicine> optionalMedicine = medicineRepository.findByMedicineName(name);
		if (optionalMedicine.isPresent())
			throw new AlreadyExistsException(MedicalStoreConstants.ALREADY_EXISTS);
		else {
			Medicine newMedicine = medicineRepository.save(medicine);
			return newMedicine;
		}
	}

	/**
	 * Get all Medicine method
	 * 
	 * @return allMedicine
	 */

	@Override
	public List<Medicine> getAllMedicine() {
		List<Medicine> allMedicine = medicineRepository.findAll();
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
	public Medicine getByMedicineName(String medicineName) {
		Optional<Medicine> optionalMedicine = medicineRepository.findByMedicineName(medicineName);
		Medicine medicine = new Medicine();

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
	public Medicine getById(int medicineId) {
		Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);
		Medicine medicine = new Medicine();
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
		Optional<Medicine> optionalMedicine = medicineRepository.findById(medicinesId);
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
		Optional<Medicine> optionalMedicine = medicineRepository.findByMedicineName(medicineName);
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
	public Medicine modifyMedicine(Medicine medicine) {
		Optional<Medicine> optionalMedicine = medicineRepository.findByMedicineName(medicine.getMedicineName());

		Medicine newMedicine = new Medicine();
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
