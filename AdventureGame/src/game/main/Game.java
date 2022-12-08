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
import game.locations.safelocations.BlackSmith;
import game.locations.safelocations.SafeHouse;

public class Game {
	
	private Scanner scanner = new Scanner(System.in);

	public void start() {
		
		System.out.println("Welcome to the Adeventure Game!");
		
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		GameCharacter character = chooseCharacter(scanner);
		System.out.println("So you chose to be a " + character.getClass().getSimpleName());
		
		Player player = new Player(name);
		player.setCharacter(character);
		player.setDamage(character.getDamage());
		player.setHealth(character.getHealth());
		player.setMoney(character.getMoney());
		
		System.out.println(player);
		
		// TODO
		System.out.println("Story");
		
		
		
		
		
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
	
	private Location goToLocation(Scanner scanner) {
		
		Location location = null;
		System.out.print("Where do you want to go next? ");
		String nextLoc = scanner.nextLine();
		
		if (nextLoc.toLowerCase().equals("safehouse")) {
			location = new SafeHouse();
			location.setOnLocation(true);
		} else if (nextLoc.toLowerCase().equals("blacksmith")) {
			location = new BlackSmith();
			location.setOnLocation(true);
		} else if (nextLoc.toLowerCase().equals("cave")) {
			location = new Cave();
			location.setOnLocation(true);
		} else if (nextLoc.toLowerCase().equals("forest")) {
			location = new Forest();
			location.setOnLocation(true);
		} else if (nextLoc.toLowerCase().equals("river")) {
			location = new River();
			location.setOnLocation(true);
		} else {
			System.out.println("You have no choice other than these five!");
			return goToLocation(scanner);
		}
		
		return location;
		
	}
}
