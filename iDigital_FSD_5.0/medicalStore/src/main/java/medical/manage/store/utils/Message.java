package medical.manage.store.utils;

import java.util.List;

import medical.manage.store.model.MedicinePurchased;
public class Message {
	
	String text;
	List<MedicinePurchased> medicines;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Message(String text ) {
		super();
		this.text = text;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public List<MedicinePurchased> getMedicines() {
		return medicines;
	}


	public void setMedicines(List<MedicinePurchased> medicines) {
		this.medicines = medicines;
	}

	
}
