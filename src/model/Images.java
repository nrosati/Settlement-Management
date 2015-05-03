package model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Images {
	private static ArrayList<BufferedImage> imagesList = new ArrayList<>();
	private static Images instance;
	
	private Images(){
		imagesList = new ArrayList<>();
		makeImages();
	}
	
	private static void makeImages(){
		try {
			File fs = new File("Images/");
			for (File f : fs.listFiles()) {
				imagesList.add(ImageIO.read(f));
			}
			/*imagesList.add(ImageIO.read(new File("Images/00dirtTile.png")));
			imagesList.add(ImageIO.read(new File("Images/01treeTile.png")));
			imagesList.add(ImageIO.read(new File("Images/02waterTile.png")));
			imagesList.add(ImageIO.read(new File("Images/03foodTile.png")));
			imagesList.add(ImageIO.read(new File("Images/04goldTile.png")));*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Images getImageInstance(){
		if(instance == null) instance = new Images();
		return instance;
	}
	
	public BufferedImage getDirt() {
		return imagesList.get(0);
	}
	
	public BufferedImage getTree() {
		return imagesList.get(1);
	}
	
	public BufferedImage getWater() {
		return imagesList.get(2);
	}
	
	public BufferedImage getFood() {
		return imagesList.get(3);
	}
	
	public BufferedImage getGold() {
		return imagesList.get(4);
	}
}
