package game.locations.safelocations.blacksmith;

import game.locations.Location;
import game.locations.safelocations.blacksmith.shopitems.ShopItem;
import game.locations.safelocations.blacksmith.shopitems.armours.Armour;
import game.locations.safelocations.blacksmith.shopitems.armours.AverageArmour;
import game.locations.safelocations.blacksmith.shopitems.armours.HeavyArmour;
import game.locations.safelocations.blacksmith.shopitems.armours.LightArmour;
import game.locations.safelocations.blacksmith.shopitems.weapons.Gun;
import game.locations.safelocations.blacksmith.shopitems.weapons.Rifle;
import game.locations.safelocations.blacksmith.shopitems.weapons.Sword;
import game.locations.safelocations.blacksmith.shopitems.weapons.Weapon;

public class BlackSmith extends Location{

	Gun gun = new Gun();
	Sword sword = new Sword();
	Rifle rifle = new Rifle();
	LightArmour lightArmour = new LightArmour();
	AverageArmour averageArmour = new AverageArmour();
	HeavyArmour heavyArmour = new HeavyArmour();
	Weapon[] weapons = {gun, sword, rifle};
	Armour[] armours = {lightArmour, averageArmour, heavyArmour};
	
	@Override
	public void locationAction() {
		
		printItemStats();
		
			
			while(true) {
				System.out.println("Do you wish to purchase anything? (Y/N)");
				String answer = getScanner().nextLine();
				if (answer.toLowerCase().equals("y")) {
					purchase();
				} else {
					return;
				}
			}
		
	}
	
	private void printItemStats() {
		System.out.println("Weapons: ");
		for (int i = 1; i <= weapons.length; i++) {
			Weapon weapon = weapons[i-1];
			System.out.format("#%d %s: \t %s (%d), %s (%d), %s %n", i, weapon.getClass().getSimpleName(), "damage", weapon.getDamage(), "price", weapon.getPrice(), (weapon.isSold() ? "SOLD OUT" : "AVAILABLE"));
		}
		System.out.println("Armours: ");
		for (int i = 1; i <= armours.length; i++) {
			Armour armour = armours[i-1];
			System.out.format("#%d %s: \t %s (%d), %s (%d), %s %n", i, armour.getClass().getSimpleName(), "damage", armour.getPery(), "price", armour.getPrice(), (armour.isSold() ? "SOLD OUT" : "AVAILABLE"));
		}
	}
	
	private void purchase() {
		System.out.println("What do you want to buy? A weapon or an armour?");
		String itemName = getScanner().nextLine();
		
		System.out.print("Enter the id of the " + itemName + ": ");
		int id = getScanner().nextInt();
		getScanner().nextLine();
		
		if (itemName.toLowerCase().equals("weapon")) {
			buyItem(weapons, id);
		} else if (itemName.toLowerCase().equals("armour")) {
			buyItem(armours, id);
		} else {
			System.out.println("A weapon or an armour! No other choice");
		}
	}
	
	private void buyItem(ShopItem[] items, int id) {
		ShopItem item;
		item = items[id - 1];
		if(getPlayer().getMoney() >= item.getPrice() && !item.isSold()) {
			getPlayer().setMoney(getPlayer().getMoney() - item.getPrice());
			item.setSold(true);
			getPlayer().getInventory().add(item);
		} else if (item.isSold()) {
			System.out.println("Item is sold out.");
		} else if (getPlayer().getMoney() < item.getPrice()) {
			System.out.println("You don't have enough money.");
		}
	}

}
