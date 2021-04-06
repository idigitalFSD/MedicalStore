package medicalStore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_id")
	private int purchaseId;

	@Column(name = "purchase_date")
	private LocalDate purchaseDate;

	@Column(name = "amount_paid")
	private double amountPaid;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Admin admin;

	// Parameterized constructor
	public Purchase(LocalDate purchaseDate, double amountPaid, String status, Admin admin) {
		super();
		this.purchaseDate = purchaseDate;
		this.amountPaid = amountPaid;
		this.status = status;
		this.admin = admin;
	}

	// Getters and setters
	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// toString()
	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + ", amountPaid=" + amountPaid
				+ ", status=" + status + ", admin=" + admin + "]";
	}

}
