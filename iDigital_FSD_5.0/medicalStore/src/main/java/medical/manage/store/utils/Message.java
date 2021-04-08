package medical.manage.store.utils;

import java.util.List;

import medical.manage.store.model.Medicine;
public class Message {
	
	String text;
	List<Medicine> medicines;
	
	
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


	public List<Medicine> getMedicines() {
		return medicines;
	}


	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	
}
