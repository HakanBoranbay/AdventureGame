package game.locations.battlelocations;

import java.util.Random;

import game.characters.enemies.Bear;
import game.locations.Location;
import game.main.Player;

public class Forest extends Location {

	String award = "FOOD";

	@Override
	public void locationAction() {
		
		Random random = new Random();
		
		int monsterNumber = (random.nextInt(3)) + 1;
		
		for (int i = 1; i <= monsterNumber; i++) {
			Bear bear = new Bear();
			battle(bear, getPlayer());
		}
		
		if (getPlayer().getHealth() > 0) System.out.println("\nWhew! You have battled " + monsterNumber + " and survived." + "\nYou gained one of the three crucial things to beat the island: " + award + "\n");
		
	}
	
	private void battle(Bear bear, Player player) {
		
		while (player.getHealth() > 0 && bear.getHealth() > 0) {
			bear.setHealth(bear.getHealth() - player.getDamage() - player.getWeapon().getDamage());
			if (bear.getHealth() > 0) { player.setHealth(player.getHealth() - bear.getDamage() + player.getArmour().getPery()); }
			if (bear.getHealth() <= 0) {
				player.setMoney(player.getMoney() + bear.getMoney());
			}
		}
		
		if (player.getHealth() <= 0) {
			System.out.println("YOU'RE DEAD!");
			return;
		}
		
	}
	
}
