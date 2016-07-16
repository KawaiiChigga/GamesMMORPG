package model.map;

import java.util.ArrayList;

import model.item.Item;

public class Village extends Map{
	public Village(String mapName) {
		super(mapName);
	}
	
	public String townHall;
	public ArrayList <Item> market;
	
	@Override
	public void printChars() {
		// TODO Auto-generated method stub
		
	}
	public void printMarket() {
		if (market.size() != 0) {
			int i = 0;
			while (i < market.size()) {
				System.out.println("Nama : " + market.get(i).namaItem);
				System.out.println("Harga : " + market.get(i).harga);
			}
		} else {
			System.out.println("Market kosong");
		}
	}
}
