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
				System.out.println(getPlayer().getInventory());
				System.out.println("Do you want to get something with you? (Y/N)");
				if (getScanner().nextLine().toLowerCase().equals("y")) {
					System.out.println("Pick the item by entering its id.");
					int pickedId = getScanner().nextInt();
					getScanner().nextLine();
					if (getPlayer().getInventory().size() < pickedId) {
						System.out.println("Pick a valid id!");
					} else if (getPlayer().getInventory().get(pickedId - 1).getClass().getSuperclass().equals(Armour.class)) {
						clearArmour();
						getPlayer().setArmour((Armour) getPlayer().getInventory().get(pickedId - 1));
						getPlayer().getInventory().get(pickedId - 1).setOnPlayer(true);
						System.out.println(getPlayer().getInventory().get(pickedId - 1).getClass());
					} else if (getPlayer().getInventory().get(pickedId - 1).getClass().getSuperclass().equals(Weapon.class)) {
						clearWeapon();
						getPlayer().setWeapon((Weapon) getPlayer().getInventory().get(pickedId - 1));
						getPlayer().getInventory().get(pickedId - 1).setOnPlayer(true);
					}
				} else {
					return;
				}
			} else {
				return;
			}
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
	
}
