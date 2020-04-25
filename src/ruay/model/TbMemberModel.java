package ruay.model;

public class TbMemberModel {
	private int id;
	private String name;
	private String surname;
	private String gender;
	private String timeReg;
	
	public TbMemberModel() {
		;
	}
	
	public TbMemberModel(int id, String name, String surname, String gender, String timeReg) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.timeReg = timeReg;
	}
	
	public TbMemberModel(String name, String surname, String gender) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}
	
	public TbMemberModel(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTimeReg() {
		return timeReg;
	}

	public void setTimeReg(String timeReg) {
		this.timeReg = timeReg;
	}

	@Override
	public String toString() {
		return "TbMemberModel [id=" + id + ", name=" + name + ", surname=" + surname + ", gender=" + gender
				+ ", timeReg=" + timeReg + ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()="
				+ getSurname() + ", getGender()=" + getGender() + ", getTimeReg()=" + getTimeReg() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
