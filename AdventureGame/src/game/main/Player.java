package game.main;

import game.characters.GameCharacter;
import game.characters.PlayerInventory;

public class Player {
	
	private int damage;
	private int health;
	private int money;
	private String name;
	private PlayerInventory inventory;
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

	public PlayerInventory getInventory() {
		return inventory;
	}

	public void setInventory(PlayerInventory inventory) {
		this.inventory = inventory;
	}

	public GameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(GameCharacter character) {
		this.character = character;
	}
	
	@Override
	public String toString() {
		return String.format("You are a %s by the name of %s. "
				+ "%nHealth point	: %d"
				+ "%nDamage		: %d"
				+ "%nMoney		: %d", 
				getCharacter().getClass().getSimpleName(), getName(), getHealth(), getDamage(), getMoney());
	}
}
