package game.locations.battlelocations;

import java.util.Random;

import game.characters.enemies.Bear;

public class Forest extends BattleLocation {

	@Override
	public void locationAction(SurvivalItem survivalItem) {

		Random random = new Random();

		int monsterNumber = (random.nextInt(3)) + 1;

		for (int i = 1; i <= monsterNumber; i++) {
			Bear bear = new Bear();
			battle(bear, getPlayer());
			if (getPlayer().getHealth() <= 0) return;
		}

		if (getPlayer().getHealth() > 0) {
			System.out.println("\nWhew! You have battled " + monsterNumber + " bears and survived.");
			if (!getPlayer().getPouch().contains(survivalItem)) {
				System.out.println("You gained one of the three crucial things to beat the island: " + survivalItem.getName() + "\n");				
				getPlayer().getPouch().add(survivalItem);
			}
		}		
	}

}
