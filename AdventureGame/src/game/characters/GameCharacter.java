package game.characters;

import java.util.ArrayList;

import game.locations.safelocations.blacksmith.shopitems.ShopItem;

public abstract class GameCharacter {

	protected String name;
	protected int damage;
	protected int health;
	protected int money;
	private ArrayList<ShopItem> inventory = new ArrayList<>();
	
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
	
	
}
