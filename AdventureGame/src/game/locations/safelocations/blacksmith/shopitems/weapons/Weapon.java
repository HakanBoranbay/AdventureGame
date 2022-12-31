package game.locations.safelocations.blacksmith.shopitems.weapons;

import game.locations.safelocations.blacksmith.shopitems.ShopItem;

public abstract class Weapon extends ShopItem {

	int damage;
	
	public int getDamage() {
		return damage;
	}
	
}
