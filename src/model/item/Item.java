package model.item;

public class Item {
	public String namaItem;
	public int hpPoint, manaPoint, attackPoint, harga;
	
	public Item(String namaItem, int hpPoint, int manaPoint, int attackPoint, int harga) {
		super();
		this.namaItem = namaItem;
		this.hpPoint = hpPoint;
		this.manaPoint = manaPoint;
		this.attackPoint = attackPoint;
		this.harga = harga;
	}
}
