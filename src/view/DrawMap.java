package view;
import java.awt.*;
import model.*;

import javax.swing.*;
public class DrawMap extends JPanel{
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	
	private static final int NUM_ROWS = 20;
	private static final int NUM_COLS = 20;
	
	public static final int PREFERRED_GRID_SIZE_PIXELS = 10;
	public DrawMap() {
		// TODO Auto-generated constructor stub
		int prefereedWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
		int preferredHiehgt = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
		setPreferredSize(new Dimension(prefereedWidth, preferredHiehgt));
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		int w = 100;
		int h = 100;
		for(int i = 0; i < NUM_ROWS; i++){
			for(int j = 0; j < NUM_COLS; j++){
				field[i][j].drawTile(g,w,h);//maybe g?
			}
		}
		
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
