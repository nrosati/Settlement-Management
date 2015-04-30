package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.ImageProducer;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Map;
import model.Tile;

//Class prints out map in a JFrame
//Problem: it takes a while for the map to propagate
//hopefully we can hurry this up or make some kind of loading screen if we get lazy

public class DrawTest {
	
			private Map map = Map.getMap(); 
			private Tile[][] field = map.getField();	 
	        private JFrame frame = new JFrame(); //creates frame	        
	        private JLabel test;
	        private JLabel test2;
	        private ImageIcon dirtTile = new ImageIcon("src/view/dirtTile.png");
	        private ImageIcon waterTile = new ImageIcon("src/view/waterTile.png");
	        private ImageIcon treeTile = new ImageIcon("src/view/treeTile.png");
	        private ImageIcon foodTile = new ImageIcon("src/view/foodTile.png");
	        private ImageIcon goldTile = new ImageIcon("src/view/goldTile.png");
	        private Tile water;
	        
	        
	        
	 
	        public DrawTest(){ 
	         
	        	 //  test2 = new JLabel(icon);
	        	
	               frame.setLayout(new GridLayout(100,100)); //set layout size
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       			   frame.setPreferredSize(new Dimension(1200, 1000));
	      
	                        // propagates map 75 x 75
       			   			String mapTile = "";
	                        for(int i = 0; i < 100; i++){
	                			for(int j = 0; j < 100; j++){
	                				int tile = field[i][j].getResourceType();
	                				//System.out.println(tile);
	                				
	                				//if(tile == 0)test.setIcon(dirtTile);
	                				if(tile == 1)test.setIcon(dirtTile);
	                				else if(tile == 2)test.setIcon(waterTile);
	                				else if(tile == 3)test.setIcon(foodTile);
	                				else if(tile == 4)test.setIcon(goldTile);
	                				//else test.setIcon(dirtTile);
	                			
	                				test = new JLabel(field[i][j].getName());	    
	                				
	                				                				
	          
	                				test.setSize(100, 100);
	                				frame.add(test);
	          
	                				//frame.add(test2);	                			            			
	          
	                				//frame.pack(); //sets appropriate size for frame
		        	                //frame.setVisible(true); //makes frame visible
		                		
	                			}
	                	
	                		//frame.add(test);
	                		         		
	                }
	                        
	                        frame.pack(); //sets appropriate size for frame
        	                frame.setVisible(true); //makes frame visible
	                       
	                
	        }
	        public static void main(String[] args) {
	                new DrawTest();// propagates new map
	        }
	}