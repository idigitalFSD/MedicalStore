package medical.manage.store.service;

import java.util.List;

import medical.manage.store.model.MedicinePurchased;

public interface MedicinePurchasedService {

	public MedicinePurchased addMedicine(MedicinePurchased medicine);
	
	public List<MedicinePurchased> getAllMedicine();
	
	public MedicinePurchased getByMedicineName(String medicineName);

	/**
	 * Get medicines by Id method
	 * 
	 * @return medicine
	 */
	MedicinePurchased getById(int medicineId);

	/**
	 * Remove medicines by Id method
	 * 
	 * @return void
	 */
	String removeById(int medicinesId);

	/**
	 * Remove medicines by medicineName method
	 * 
	 * @return void
	 */
	String removeByMedicineName(String medicineName);

	/**
	 * Modify medicine method
	 * 
	 * @return medicineModified
	 */
	MedicinePurchased modifyMedicine(MedicinePurchased medicine);

}
