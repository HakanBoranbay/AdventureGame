package game.main;

import java.util.Scanner;

import game.characters.GameCharacter;
import game.characters.maincharacters.Archer;
import game.characters.maincharacters.Knight;
import game.characters.maincharacters.Samurai;
import game.locations.Location;
import game.locations.battlelocations.Cave;
import game.locations.battlelocations.Forest;
import game.locations.battlelocations.River;
import game.locations.safelocations.SafeHouse;
import game.locations.safelocations.blacksmith.BlackSmith;
import game.locations.safelocations.blacksmith.shopitems.armours.SimpleClothes;
import game.locations.safelocations.blacksmith.shopitems.weapons.BareHands;

public class Game {
	
	private Scanner scanner = new Scanner(System.in);
	Player player;

	Location location;
	SafeHouse safeHouse = new SafeHouse();
	BlackSmith blackSmith = new BlackSmith();
	Cave cave = new Cave();
	Forest forest = new Forest();
	River river = new River();

	public void start() {
		
		System.out.println("Welcome to the Adeventure Game!");
		
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		GameCharacter character = chooseCharacter(scanner);
		System.out.println("So you chose to be a " + character.getClass().getSimpleName());
		
		this.player = new Player(name);
		player.setCharacter(character);
		player.setDamage(character.getDamage());
		player.setHealth(character.getHealth());
		player.setMoney(character.getMoney());
		player.setInventory(character.getInventory());
		player.setArmour(new SimpleClothes());
		player.setWeapon(new BareHands());
		

		System.out.println(player);
		
		// TODO
		System.out.println("Story");

		while (player.getHealth() > 0) {
			
			goToLocation(scanner);
			
		}
		
		
		
//		Player player = new Player(name);
	}
	
	private GameCharacter chooseCharacter(Scanner scanner) {
		
		GameCharacter player = null;
		System.out.print("Choose your character: ");
		String charName = scanner.nextLine();
		
		if (charName.toLowerCase().equals("archer")) {
			player = new Archer();
		} else if(charName.toLowerCase().equals("knight")) {
			player = new Knight();
		} else if(charName.toLowerCase().equals("samurai")) {
			player = new Samurai();
		} else {
			System.out.println("You have no choice other than these three!");
			return chooseCharacter(scanner);
		}
		
		return player;
	}
	
	private void goToLocation(Scanner scanner) {
		
		System.out.print("Where do you want to go next? ");
		String nextLoc = scanner.nextLine();
		
		if (nextLoc.toLowerCase().equals("safehouse")) {
			location = safeHouse;
		} else if (nextLoc.toLowerCase().equals("blacksmith")) {
			location = blackSmith;
		} else if (nextLoc.toLowerCase().equals("cave")) {
			location = cave;
		} else if (nextLoc.toLowerCase().equals("forest")) {
			location = forest;
		} else if (nextLoc.toLowerCase().equals("river")) {
			location = river;
		} else {
			System.out.println("You have no choice other than these five!");
			goToLocation(scanner);
		}
		
		location.setScanner(scanner);
		location.setPlayer(player);
		location.locationAction();
		
		System.out.println(player);
		
	}
	
}
