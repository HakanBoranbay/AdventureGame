package game.locations.battlelocations;

import game.characters.enemies.Enemy;
import game.locations.Location;
import game.main.Player;

public class BattleLocation extends Location {

	public void battle(Enemy enemy, Player player) {

		while (player.getHealth() > 0 && enemy.getHealth() > 0) {
			enemy.setHealth(enemy.getHealth() - (player.getDamage() + player.getWeapon().getDamage()));
			if (enemy.getHealth() > 0) { 
				player.setHealth(player.getHealth() + player.getArmour().getPery() - enemy.getDamage()); 
			}
			if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
				player.setMoney(player.getMoney() + enemy.getMoney());
			}
		}

		if (player.getHealth() <= 0) {
			System.out.println("YOU'RE DEAD!");
			return;
		}

	}
}
