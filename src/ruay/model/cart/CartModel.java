package ruay.model.cart;

import ruay.model.TbGoodModel;

public class CartModel {
	private TbGoodModel goods;
	private int quantity;
	
	public CartModel() {
		super();
	}

	public CartModel(TbGoodModel goods, int quantity) {
		super();
		this.goods = goods;
		this.quantity = quantity;
	}

	public TbGoodModel getGoods() {
		return goods;
	}

	public void setGoods(TbGoodModel goods) {
		this.goods = goods;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartModel [goods=" + goods + ", quantity=" + quantity + ", getGoods()=" + getGoods()
				+ ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
