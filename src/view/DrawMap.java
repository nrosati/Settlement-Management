package view;
import java.awt.*;
import java.awt.image.BufferedImage;

import model.*;

import javax.swing.*;
public class DrawMap extends JPanel{
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	BufferedImage im = new BufferedImage(3000,3000,BufferedImage.TYPE_INT_RGB);
	
	public DrawMap() {
		init();
		
		
	}
	public void init(){
		Graphics g = im.getGraphics();
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				field[i][j].drawTile(g);
			}
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(im,0,0,null);
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("GameMap");
		DrawMap draw = new DrawMap();
		frame.add(draw);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
