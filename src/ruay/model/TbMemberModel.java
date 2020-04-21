package ruay.model;

public class TbMemberModel {
	private int id;
	private String name;
	private String surname;
	private String sex;

	public TbMemberModel(int id, String name, String surname, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "TbMemberModel [id=" + id + ", name=" + name + ", surname=" + surname + ", sex=" + sex + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getSex()=" + getSex()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
