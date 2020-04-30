package ruay.model;

public class TbGoodModel {
	private int id;
	private String name;
	private double unitCost;
	private double unitPrice;
	private String images;

	public TbGoodModel() {
		super();
	}

	public TbGoodModel(int id) {
		super();
		this.id = id;
	}

	public TbGoodModel(int id, String name, double unitCost, double unitPrice, String images) {
		super();
		this.id = id;
		this.name = name;
		this.unitCost = unitCost;
		this.unitPrice = unitPrice;
		this.images = images;
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

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "TbGoodModel [id=" + id + ", name=" + name + ", unitCost=" + unitCost + ", unitPrice=" + unitPrice
				+ ", images=" + images + ", getId()=" + getId() + ", getName()=" + getName() + ", getUnitCost()="
				+ getUnitCost() + ", getUnitPrice()=" + getUnitPrice() + ", getImages()=" + getImages()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
