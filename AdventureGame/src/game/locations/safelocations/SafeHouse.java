package game.locations.safelocations;

import game.locations.Location;
import game.locations.safelocations.blacksmith.shopitems.ShopItem;
import game.locations.safelocations.blacksmith.shopitems.armours.Armour;
import game.locations.safelocations.blacksmith.shopitems.weapons.Weapon;

public class SafeHouse extends Location{

	@Override
	public void locationAction() {
		getPlayer().setHealth(getPlayer().getCharacter().getHealth());
		System.out.println("Player Health Restored!");

		if (getPlayer().getInventory().size() != 0) {
			System.out.println("Do you want to check your inventory? (Y/N)");
			String inventoryAnswer = getScanner().nextLine();

			if (inventoryAnswer.toLowerCase().equals("y")) {
				printInventory();
				System.out.println("Do you want to equip something? (Y/N)");
				if (getScanner().nextLine().toLowerCase().equals("y")) {
					System.out.println("Pick the item by entering its id.");
					int pickedId = getScanner().nextInt();
					equipItem(pickedId);
				}
			} else {
				return;
			}
		} else {
			return;
		}
	}

	private void clearArmour() {

		for (ShopItem item : getPlayer().getInventory()) {
			if (item.getClass().equals(Armour.class)) {
				item.setOnPlayer(false);
			}
		}
	}

	private void clearWeapon() {

		for (ShopItem item : getPlayer().getInventory()) {
			if (item.getClass().equals(Weapon.class)) {
				item.setOnPlayer(false);
			}
		}
	}

	private void printInventory() {
		String inventoryFormat = "%5s \t %15s \t %10s \t %10s%n";
		System.out.format(inventoryFormat,"ID","NAME","DAMAGE/PERY","EQUIPPED");
		System.out.println("----- \t --------------- \t ---------- \t ----------");

		for(int i = 0; i < getPlayer().getInventory().size(); i++) {
			if(getPlayer().getInventory().get(i).getClass().getSuperclass().equals(Armour.class)) {
				Armour item = (Armour) getPlayer().getInventory().get(i);
				System.out.format(inventoryFormat, i+1, item.getClass().getSimpleName(), item.getPery(), item.isOnPlayer());
			} else {
				Weapon item = (Weapon) getPlayer().getInventory().get(i);
				System.out.format(inventoryFormat, i+1, item.getClass().getSimpleName(), item.getDamage(), item.isOnPlayer());
			}
		}
	}

	private void equipItem(int i) {
		getScanner().nextLine();
		ShopItem item = getPlayer().getInventory().get(i - 1);
		if (getPlayer().getInventory().size() < i) {
			System.out.println("Pick a valid id!");
		} else if (item.getClass().getSuperclass().equals(Armour.class)) {
			clearArmour();
			getPlayer().setArmour((Armour) getPlayer().getInventory().get(i - 1));
			item.setOnPlayer(true);
		} else if (getPlayer().getInventory().get(i - 1).getClass().getSuperclass().equals(Weapon.class)) {
			clearWeapon();
			getPlayer().setWeapon((Weapon) getPlayer().getInventory().get(i - 1));
			item.setOnPlayer(true);
		}
	}

}
