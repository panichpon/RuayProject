package ruay.model;

public class TbCustomerModel {
	private int id;
	private String name;
	private String surname;
	private String username;
	private String password;
	private int address;
	private int postcode;
	private int bank_acct;
	private double balance;
	private int verified;

	public TbCustomerModel(int id, String name, String surname, String username, String password, int address,
			int postcode, int bank_acct, double balance, int verified) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.postcode = postcode;
		this.bank_acct = bank_acct;
		this.balance = balance;
		this.verified = verified;
	}

	public TbCustomerModel(String name, String surname, String username, String password, int address, int postcode,
			int bank_acct) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.postcode = postcode;
		this.bank_acct = bank_acct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public int getBank_acct() {
		return bank_acct;
	}

	public void setBank_acct(int bank_acct) {
		this.bank_acct = bank_acct;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getVerified() {
		return verified;
	}

	public void setVerified(int verified) {
		this.verified = verified;
	}

	@Override
	public String toString() {
		return "TbCustomerModel [id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username
				+ ", password=" + password + ", address=" + address + ", postcode=" + postcode + ", bank_acct="
				+ bank_acct + ", balance=" + balance + ", verified=" + verified + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress() + ", getPostcode()="
				+ getPostcode() + ", getBank_acct()=" + getBank_acct() + ", getBalance()=" + getBalance()
				+ ", getVerified()=" + getVerified() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
