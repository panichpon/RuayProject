package ruay.model;

public class TbInvoiceModel {
	private int id;
	private TbCustomerModel customer;
	private int customerId;
	private String invoiceDate;
	private double totalAmount;
	
	public TbInvoiceModel(int id, TbCustomerModel customer, int customerId, String invoiceDate, double totalAmount) {
		super();
		this.id = id;
		this.customer = customer;
		this.customerId = customerId;
		this.invoiceDate = invoiceDate;
		this.totalAmount = totalAmount;
	}
	
	public TbInvoiceModel(int id, int customerId, String invoiceDate, double totalAmount) {
		this.id = id;
		this.customerId = customerId;
		this.invoiceDate = invoiceDate;
		this.totalAmount = totalAmount;
	}
	
	public TbInvoiceModel(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TbCustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(TbCustomerModel customer) {
		this.customer = customer;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "TbInvoiceModel [id=" + id + ", customer=" + customer + ", customerId=" + customerId + ", invoiceDate="
				+ invoiceDate + ", totalAmount=" + totalAmount + ", getId()=" + getId() + ", getCustomer()="
				+ getCustomer() + ", getCustomerId()=" + getCustomerId() + ", getInvoiceDate()=" + getInvoiceDate()
				+ ", getTotalAmount()=" + getTotalAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
