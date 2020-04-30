package ruay.model;

public class TbStockModel {
	private int id;
	private int goodId;
	private TbGoodModel good;
	private int quantity;
	private int replenish;

	public TbStockModel() {
		super();
	}

	public TbStockModel(int id) {
		super();
		this.id = id;
	}

	public TbStockModel(int id, int goodId, TbGoodModel good, int quantity, int replenish) {
		super();
		this.id = id;
		this.goodId = goodId;
		this.good = good;
		this.quantity = quantity;
		this.replenish = replenish;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReplenish() {
		return replenish;
	}

	public void setReplenish(int replenish) {
		this.replenish = replenish;
	}
	
	public TbGoodModel getGood() {
		return good;
	}

	public void setGood(TbGoodModel good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "TbStockModel [id=" + id + ", goodId=" + goodId + ", quantity=" + quantity + ", replenish=" + replenish
				+ ", getId()=" + getId() + ", getGoodId()=" + getGoodId() + ", getQuantity()=" + getQuantity()
				+ ", getReplenish()=" + getReplenish() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
