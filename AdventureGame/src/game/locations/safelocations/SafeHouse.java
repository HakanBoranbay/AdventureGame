package game.locations.safelocations;

import game.locations.Location;
import game.main.Player;

public class SafeHouse extends Location{
	
	public void restoreHealth(Player player) {
		player.setHealth(player.getCharacter().getHealth());
	}
	
	
}
