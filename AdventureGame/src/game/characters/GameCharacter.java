package game.characters;

import java.util.ArrayList;

import game.locations.battlelocations.SurvivalItem;
import game.locations.safelocations.blacksmith.shopitems.ShopItem;

public abstract class GameCharacter {

	protected String name;
	protected int damage;
	protected int health;
	protected int money;
	private ArrayList<ShopItem> inventory = new ArrayList<>();
	private ArrayList<SurvivalItem> pouch = new ArrayList<>();
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public ArrayList<ShopItem> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<ShopItem> inventory) {
		this.inventory = inventory;
	}
	public ArrayList<SurvivalItem> getPouch() {
		return pouch;
	}
	public void setPouch(ArrayList<SurvivalItem> pouch) {
		this.pouch = pouch;
	}
	
	
}
