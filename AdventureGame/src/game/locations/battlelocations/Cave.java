package game.locations.battlelocations;

import java.util.Random;

import game.characters.enemies.Zombie;
import game.locations.Location;
import game.main.Player;

public class Cave extends Location{
	
	String award = "FOOD";

	@Override
	public void locationAction() {
		
		Random random = new Random();
		
		int monsterNumber = (random.nextInt(3)) + 1;
		
		for (int i = 1; i <= monsterNumber; i++) {
			Zombie zombie = new Zombie();
			battle(zombie, getPlayer());
		}
		
		if (getPlayer().getHealth() > 0) System.out.println("\nWhew! You have battled " + monsterNumber + " and survived." + "\nYou gained one of the three crucial things to beat the island: " + award + "\n");
		
	}
	
	private void battle(Zombie zombie, Player player) {
		
		while (player.getHealth() > 0 && zombie.getHealth() > 0) {
			zombie.setHealth(zombie.getHealth() - player.getDamage() - player.getWeapon().getDamage());
			if (zombie.getHealth() > 0) { 
				player.setHealth(player.getHealth() - zombie.getDamage() + player.getArmour().getPery()); 
			}
			if (zombie.getHealth() <= 0) {
				player.setMoney(player.getMoney() + zombie.getMoney());
			}
		}
		
		if (player.getHealth() <= 0) {
			System.out.println("YOU'RE DEAD!");
			return;
		}
		
	}
	
}
