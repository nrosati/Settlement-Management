package view;
import java.awt.*;
import java.awt.image.BufferedImage;

import model.*;

import javax.swing.*;
public class DrawMap extends JPanel{
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	BufferedImage im = new BufferedImage(3200,3200,BufferedImage.TYPE_INT_RGB);
	
	public DrawMap() {
		init();
		
		
	}
	public void init(){
		map.getMapImage();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(map.getMapImage(),0,0,null);
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("GameMap");
		DrawMap draw = new DrawMap();
		frame.add(draw);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1000);
		frame.setVisible(true);
	}

}
