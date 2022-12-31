package game.locations.safelocations.blacksmith.shopitems;

public abstract class ShopItem {

	boolean onPlayer = false;
	boolean isSold = false;
	int price;
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean isSold() {
		return isSold;
	}
	
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public boolean isOnPlayer() {
		return onPlayer;
	}

	public void setOnPlayer(boolean onPlayer) {
		this.onPlayer = onPlayer;
	}
	
}
