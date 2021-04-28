package medical.manage.store.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_details_id")
	private int orderDetailsId;

	@Column(name = "input_manufacturer_id")
	private int inputManufacturerId;

	@Column(name = "input_medicine_id")
	private int inputMedicineId;

	@Column(name = "quantity_ordered")
	private int quantityOrdered;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "custId")
	private List<Customer> customer;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int orderDetailsId, int inputManufacturerId, int inputMedicineId, int quantityOrdered,
			List<Customer> customer) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.inputManufacturerId = inputManufacturerId;
		this.inputMedicineId = inputMedicineId;
		this.quantityOrdered = quantityOrdered;
		this.customer = customer;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
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

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", inputManufacturerId=" + inputManufacturerId
				+ ", inputMedicineId=" + inputMedicineId + ", quantityOrdered=" + quantityOrdered + ", customer="
				+ customer + "]";
	}

}
