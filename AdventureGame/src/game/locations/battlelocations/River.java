package game.locations.battlelocations;

import java.util.Random;

import game.characters.enemies.Vampire;
import game.locations.Location;
import game.main.Player;

public class River extends Location {

	String award = "FOOD";

	@Override
	public void locationAction() {
		
		Random random = new Random();
		
		int monsterNumber = (random.nextInt(3)) + 1;
		
		for (int i = 1; i <= monsterNumber; i++) {
			Vampire vampire = new Vampire();
			battle(vampire, getPlayer());
		}
		
		if (getPlayer().getHealth() > 0) System.out.println("\nWhew! You have battled " + monsterNumber + " and survived." + "\nYou gained one of the three crucial things to beat the island: " + award + "\n");
		
	}
	
	private void battle(Vampire vampire, Player player) {
		
		while (player.getHealth() > 0 && vampire.getHealth() > 0) {
			vampire.setHealth(vampire.getHealth() - player.getDamage() - player.getWeapon().getDamage());
			if (vampire.getHealth() > 0) { player.setHealth(player.getHealth() - vampire.getDamage() + player.getArmour().getPery()); }
			if (vampire.getHealth() <= 0) {
				player.setMoney(player.getMoney() + vampire.getMoney());
			}
		}
		
		if (player.getHealth() <= 0) {
			System.out.println("YOU'RE DEAD!");
			return;
		}
		
	}
}
