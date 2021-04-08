package medical.manage.store.service;

import java.util.List;

import medical.manage.store.model.Medicine;

public interface MedicineService {

	/**
	 * Adds medicine to medicine table
	 * 
	 * @return medicineCreation
	 */
	public Medicine addMedicine(Medicine medicine);

	/**
	 * Get users by medicineName method
	 * 
	 * @return medicine
	 */
	public Medicine getByMedicineName(String medicineName);

	/**
	 * Get all Medicine method
	 * 
	 * @return allMedicine
	 */
	public List<Medicine> getAllMedicine();

	/**
	 * Get medicines by Id method
	 * 
	 * @return medicine
	 */
	public Medicine getById(int medicineId);

	/**
	 * Remove medicines by Id method
	 * 
	 * @return void
	 */
	public String removeById(int medicinesId);

	/**
	 * Remove medicines by medicineName method
	 * 
	 * @return void
	 */
	public String removeByMedicineName(String medicineName);

	/**
	 * Modify medicine method
	 * 
	 * @return medicineModified
	 */
	public Medicine modifyMedicine(Medicine medicine);

}
