package model.map;

import java.util.ArrayList;
import model.character.Character;

public abstract class Map {
	public String mapName;
	public ArrayList <Character> chars;
	public abstract void printChars();
	
	public Map(String mapName) {
		super();
		this.mapName = mapName;
	}
	
	
}
