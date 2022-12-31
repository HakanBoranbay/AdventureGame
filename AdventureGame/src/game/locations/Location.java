package game.locations;

import java.util.Scanner;

import game.main.Player;

public abstract class Location {

	Scanner scanner;
	Player player;
	boolean onLocation = false;
	
	public void setOnLocation(boolean onLocation) {
		this.onLocation = onLocation;
	}

	public boolean isOnLocation() {
		return onLocation;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Scanner getScanner() {
		return scanner;
	}

	public void locationAction() {}
	
}
