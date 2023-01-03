package game.main;

import java.util.ArrayList;

import game.characters.GameCharacter;
import game.locations.battlelocations.SurvivalItem;
import game.locations.safelocations.blacksmith.shopitems.ShopItem;
import game.locations.safelocations.blacksmith.shopitems.armours.Armour;
import game.locations.safelocations.blacksmith.shopitems.weapons.Weapon;

public class Player {
	
	private int damage;
	private int health;
	private int money;
	private String name;
	private ArrayList<ShopItem> inventory;
	private ArrayList<SurvivalItem> pouch;
	private Armour armour;
	private Weapon weapon;
	private GameCharacter character;
	
	public Player(String name) {
		this.name = name;
	}

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

	public GameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(GameCharacter character) {
		this.character = character;
	}
	
	public Armour getArmour() {
		return armour;
	}

	public void setArmour(Armour armour) {
		this.armour = armour;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return String.format("%nYou are a %s by the name of %s. "
				+ "%nHealth point	: %d"
				+ "%nDamage		: %d"
				+ "%nMoney		: %d"
				+ "%nArmour		: %s"
				+ "%nWeapon		: %s%n", 
				getCharacter().getClass().getSimpleName(), getName(), getHealth(), getDamage(), getMoney(), getArmour().getClass().getSimpleName(), getWeapon().getClass().getSimpleName());
	}
}
