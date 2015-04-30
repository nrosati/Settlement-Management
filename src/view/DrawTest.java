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
	        private ImageIcon icon = new ImageIcon("src/model/tileTest.png");
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
	                				String tile = field[i][j].getName();
	                				
	                				
	                				if(tile.contains("grassLand"))test.setIcon(icon);
	                			
	                				test = new JLabel(tile);	    
	                				
	                				                				
	          
	                				test.setSize(100, 100);
	                				frame.add(test);
	          
	                				//frame.add(test2);	                			            			
	          
		        	                frame.pack(); //sets appropriate size for frame
		        	                frame.setVisible(true); //makes frame visible
		                		
	                			}
	                	
	                		frame.add(test);
	                		         		
	                }
	                        
	                        
	                       
	                
	        }
	        public static void main(String[] args) {
	                new DrawTest();// propagates new map
	        }
	}