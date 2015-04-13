package model;

public class TerrainItems {
	private boolean density;
	//private file itemName;
	public TerrainItems() {
		// TODO Auto-generated constructor stub
		density = false;
		//itemName =;
	}
	
	public void getSprite(){
		//not void going to return the sprite filename
	}
	/**
	 * Returns whether a terrain item is dense or not.
	 * Density determines if a player or object can
	 * be used on this tile.
	 * 
	 * @return boolean
	 */
	public boolean isDense(){
		return density;
	}

}
