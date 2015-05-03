package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Map;
import model.Tile;

public class HasiMapTest extends JPanel{
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	
	JPanel panel;
	
	public void makeMapPanel(){
		panel.setSize(new Dimension(32 * 100, 32 * 100));
		panel.setPreferredSize(new Dimension(32 * 100, 32 * 100));
		panel = new JPanel();
		final long serialVersionUID = 3277456389480389779L;
		
				
		
	}
}
