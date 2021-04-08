package medical.manage.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "purchase_Details")
public class PurchaseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_detail_id")
	private int purchaseDetailId;

	@Column(name = "quantity_purchase")
	private int quantityPurchase;

	@Column(name = "price_each")
	private float priceEach;

	@Column(name = "input_manufacturer_id")
	private int inputManufacturerId;

	@Column(name = "input_medicine_id")
	private int inputMedicineId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Purchase purchase;

	// Parameterized constructor
	public PurchaseDetails(int quantityPurchase, float priceEach, int inputManufacturerId, int inputMedicineId,
			Purchase purchase) {
		super();
		this.quantityPurchase = quantityPurchase;
		this.priceEach = priceEach;
		this.inputManufacturerId = inputManufacturerId;
		this.inputMedicineId = inputMedicineId;
		this.purchase = purchase;
	}

	// Getters and Setters
	public int getPurchaseDetailId() {
		return purchaseDetailId;
	}

	public void setPurchaseDetailId(int purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}

	public int getQuantityPurchase() {
		return quantityPurchase;
	}

	public void setQuantityPurchase(int quantityPurchase) {
		this.quantityPurchase = quantityPurchase;
	}

	public float getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(float priceEach) {
		this.priceEach = priceEach;
	}

	public int getInputManufacturerId() {
		return inputManufacturerId;
	}

	public void setInputManufacturerId(int inputManufacturerId) {
		this.inputManufacturerId = inputManufacturerId;
	}

	public int getInputMedicineId() {
		return inputMedicineId;
	}

	public void setInputMedicineId(int inputMedicineId) {
		this.inputMedicineId = inputMedicineId;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	// toString()
	@Override
	public String toString() {
		return "PurchaseDetails [purchaseDetailId=" + purchaseDetailId + ", quantityPurchase=" + quantityPurchase
				+ ", priceEach=" + priceEach + ", inputManufacturerId=" + inputManufacturerId + ", inputMedicineId="
				+ inputMedicineId + ", purchase=" + purchase + "]";
	}

}
