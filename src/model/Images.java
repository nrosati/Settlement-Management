package model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Images {
	private static ArrayList<BufferedImage> imagesList = new ArrayList<>();
	private static Images instance; // Singleton return the instance of this class
	/**
	 * Singleton class that creates bufferedImages for all of our terrain items
	 * and adds them to an array list
	 */
	private Images(){
		imagesList = new ArrayList<>();
		makeImages();
	}
	/**
	 * Makes a buffered Image for all of the images in the
	 * Images folder and adds them to an 
	 * ArrayList
	 */
	private static void makeImages(){
		try {
			File fs = new File("Images/");//File Images folder
			for (File f : fs.listFiles()) {//for all the files in this folder
				imagesList.add(ImageIO.read(f));//add the image to our ArrayList of images
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Returns the instance of the Images class
	 * @return
	 */
	public static Images getImageInstance(){
		if(instance == null) instance = new Images();
		return instance;
	}
	/**
	 * Returns the bufferedImage of the dirtTile
	 * @return
	 */
	public BufferedImage getDirt() {
		return imagesList.get(0);
	}
	/**
	 * Returns the bufferedImage of the treeTile
	 * @return
	 */
	public BufferedImage getTree() {
		return imagesList.get(1);
	}
	/**
	 * Returns the bufferedImage of the waterTile
	 * @return
	 */
	public BufferedImage getWater() {
		return imagesList.get(2);
	}
	/**
	 * Returns the bufferedImage of the foodTile
	 * @return
	 */
	public BufferedImage getFood() {
		return imagesList.get(3);
	}
	/**
	 * Returns the bufferedImage of the goldTile
	 * @return
	 */
	public BufferedImage getGold() {
		return imagesList.get(4);
	}
	/**
	 * returns the bufferedImage of the agent 
	 * @return
	 */
	public BufferedImage getAgentTile(){
		return imagesList.get(5);
	}
	
	public BufferedImage getSand(){
		return imagesList.get(6);
	}
	public BufferedImage getJungle(){
		return imagesList.get(7);
	}
	public BufferedImage getSnow(){
		return imagesList.get(8);
	}
	public BufferedImage getStoreHouse(){
		return imagesList.get(9);
	}
	public BufferedImage getBarracks(){
		return imagesList.get(10);
	}
	
	public BufferedImage getPhilosopher(){
		return imagesList.get(11);
	}
}
