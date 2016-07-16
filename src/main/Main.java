package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.character.*;
import model.map.Graveyard;
import view.Maps;

public class Main {
	public static void printMenu() {
		System.out.println("= = = = = M E N U = = = = =");
		System.out.println("1. Print Human");
		System.out.println("2. Print Monster");
	}
	public static Scanner scan = new Scanner(System.in);
	public static Scanner scanInt = new Scanner(System.in);
	
	public static void main(String[] args) {
//		String pilihan;
//		ArrayList <Human> listHuman = new ArrayList <>();
//		Human m1 = new Human("Daniel", "Mage");
//		Human m2 = new Human("Glenn", "Warrior");
//		
//		listHuman.add(m1);
//		listHuman.add(m2);
//		
//		ArrayList <Monster> listMonster = new ArrayList <>();
//		Sentinel sentinel = new Sentinel("Groot");
//		Ghost ghost = new Ghost("Valak");
//		Goblin goblin = new Goblin("Techies");
//		
//		Graveyard grave = new Graveyard("Grave");
////		grave.chars.add(ghost);
//		
//		listMonster.add(sentinel);
//		listMonster.add(ghost);
//		listMonster.add(goblin);
//		
//		do {
//			printMenu();
//			System.out.print("Masukkan pilihan : ");
//			pilihan = scan.nextLine();
//			
//			switch (pilihan) {
//				case "1" : {
//					for (Human human : listHuman) {
//						human.printData();
//						System.out.println();
//					}
//				}break;
//				case "2" : {
//					for (Monster monster : listMonster) {
//						monster.printData();
//						System.out.println();
//					}
//				}break;
//			}
//		}while (!pilihan.equals("exit"));
		
		new Maps();
	}

}
