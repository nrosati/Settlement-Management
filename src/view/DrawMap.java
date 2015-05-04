package view;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import model.*;

import javax.swing.*;
public class DrawMap extends JPanel implements Observer{
	private Map map = Map.getMap(); 
	private Tile[][] field = map.getField();
	private BufferedImage img = map.getMapImage();
	private JScrollPane wrapper;
	private JPanel panel;
	/**
	 * Test for drawing the Map
	 */
	public DrawMap() {
		makePanel();
		init();
		
		
	}
	public void init(){
		//map.getMapImage();
		
		for(int i = 0; i < 100; i ++){
			for(int j = 0; j < 100; j++){
				field[i][j].addObserver(this);
			}
		}
		panel.setSize(new Dimension(32 * 100, 32 * 100));
		panel.setPreferredSize(new Dimension(32 * 100, 32 * 100));
		wrapper = new JScrollPane(panel);
		wrapper.setSize(new Dimension(600, 400));
		wrapper.setPreferredSize(new Dimension(600,400));
		wrapper.setViewportView(new JViewport().add(panel));
		//this.add(wrapper);
	}
	public void makePanel(){
		panel = new JPanel(){
			public void paintComponent(Graphics g){
		
			super.paintComponent(g);
			g.drawImage(img,0,0,null);
			}
		};
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("GameMap");
		DrawMap draw = new DrawMap();
		frame.add(draw.wrapper);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(3200,3200);
		frame.setVisible(true);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = Map.getMap();
		map.addAgent("Socrates", 1, 1);
		map.addAgent("Plato", 1, 3);
		map.addAgent("Hercules", 1, 5);
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("About to update tile");
		Graphics2D g = (Graphics2D) img.getGraphics();
		((Tile) arg).drawTile(g, ((Tile) arg).getXChord() * 32, ((Tile) arg).getYChord() * 32);
		//map.drawMap();
		//img = map.getMapImage();
		repaint();
		wrapper.setViewportView(new JViewport().add(panel));
		System.out.println("Tile was changed");
		
	}

}
