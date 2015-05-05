package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPanel panel, controlPanel, buttons;
	private JList<String> agentList;
	private DefaultListModel<String> list;
	private JButton addAgent, buildStoreHouse, buildBarracks, gatherFood, gatherGold, gatherWood, water;
	/**
	 * Initializes the various components of the map
	 */
	public DrawMap() {
		makePanel();
		makeControls();
		init();
		RegisterListeners();
		
		
		
	}
	/**
	 * First adds the current class as an observer for all the tiles.
	 * Sets the size of the map panel and adds it to the scroll wrapper
	 * which then also sets the size.
	 */
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
		wrapper.setSize(new Dimension(800, 600));
		wrapper.setPreferredSize(new Dimension(800,600));
		wrapper.setViewportView(new JViewport().add(panel));
		//wrapper.setViewportView(new JViewport().add(agentList));
		//this.add(wrapper);
	}
	/**
	 * Makes a JPanel which holds the map image
	 */
	public void makePanel(){
		panel = new JPanel(){
			public void paintComponent(Graphics g){
		
			super.paintComponent(g);
			g.drawImage(img,0,0,null);
			}
		};
	}
	/**
	 * Creates the agent list and the button panel.
	 * Creates the buttons and adds them to the panel.
	 */
	public void makeControls(){
		controlPanel = new JPanel();
		list = new DefaultListModel<String>();
		for(Agent agent: map.getAgents()){
			String element = agent.getName();
			list.addElement(element);
		}
		agentList = new JList<String>(list);
		agentList.setSize(new Dimension(200, 200));
		agentList.setPreferredSize(new Dimension(200, 200));
		agentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		agentList.setVisible(true);
		
		addAgent = new JButton();
		addAgent.setText("Add Agent");
		addAgent.setVisible(true);
		buildStoreHouse = new JButton();
		buildStoreHouse.setText("Build Store House");
		buildStoreHouse.setVisible(true);
		buildBarracks = new JButton();
		buildBarracks.setText("Build Barracks");
		buildBarracks.setVisible(true);
		gatherWood = new JButton();
		gatherWood.setText("Gather Wood");
		gatherWood.setVisible(true);
		gatherFood = new JButton();
		gatherFood.setText("Gather Food");
		gatherFood.setVisible(true);
		gatherGold = new JButton();
		gatherGold.setText("Gather Gold");
		gatherGold.setVisible(true);
		water = new JButton();
		water.setText("Gather Water");
		water.setVisible(true);
		buttons = new JPanel();
		buttons.add(addAgent);
		buttons.add(buildStoreHouse);
		buttons.add(buildBarracks);
		buttons.add(gatherGold);
		buttons.add(gatherWood);
		buttons.add(gatherFood);
		buttons.add(water);
	}
	/**
	 * Returns the listeners to the buttons
	 */
	private void RegisterListeners(){
		GameListeners gl = new GameListeners();
		addAgent.addActionListener(gl);
		buildStoreHouse.addActionListener(gl);
		buildBarracks.addActionListener(gl);
		gatherWood.addActionListener(gl);
		gatherFood.addActionListener(gl);
		gatherGold.addActionListener(gl);
		water.addActionListener(gl);
	}
	/**
	 * Creates the action listeners.  Mainly adds an agent
	 * builds two buildings, or gather a given resource.
	 * @author Nick
	 *
	 */
	private class GameListeners implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == addAgent)map.addAgent("Agent", 1, 7);
			if(e.getSource() == buildStoreHouse){
				int select = agentList.getSelectedIndex();
				Agent agent = map.getAgents().get(select);
				agent.buildBuilding("StoreHouse", agent.getXLoc(), agent.getYLoc());
				
			}
			if(e.getSource() == buildBarracks){
				int select = agentList.getSelectedIndex();
				Agent agent = map.getAgents().get(select);
				System.out.print(agent.getName());
				agent.buildBuilding("Barracks", agent.getXLoc(), agent.getYLoc());
			}	
			if(e.getSource() == gatherWood){
				int select = agentList.getSelectedIndex();
				Agent agent = map.getAgents().get(select);
				//agent.gatherResource(1) should pass it an int then the agent will go looking for that resource
			}
			if(e.getSource() == gatherFood){
				int select = agentList.getSelectedIndex();
				Agent agent = map.getAgents().get(select);
				//agent.gatherResource(3)
			}
			if(e.getSource() == gatherGold){
				int select = agentList.getSelectedIndex();
				Agent agent = map.getAgents().get(select);
				//agent.gatherResource(4)
			}
			if(e.getSource() == water){
				int select = agentList.getSelectedIndex();
				Agent agent = map.getAgents().get(select);
				//agent.gatherResource(2)
			}
		}
		
	}
	/**
	 * Main method adds all the panels to the frame and sets
	 * the frames default size.
	 * @param args
	 */
	public static void main(String[] args){
		Map map = Map.getMap();
		
		JFrame frame = new JFrame("GameMap");
		frame.setLayout(new BorderLayout());
		DrawMap draw = new DrawMap();
		map.addAgent("Socrates", 1, 1);
		
		map.addAgent("Plato", 1, 3);
		map.addAgent("Hercules", 1, 5);
		frame.add(draw.wrapper, BorderLayout.WEST);
		frame.add(draw.buttons, BorderLayout.SOUTH);
		
		frame.add(draw.agentList,BorderLayout.EAST);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(3200,3200);
		frame.setVisible(true);
		
		
		
		
	}
	/**
	 * Observable update method.  Updates the list of agents
	 * and the map image.
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("About to update tile");
		Graphics2D g = (Graphics2D) img.getGraphics();
		((Tile) arg).drawTile(g, ((Tile) arg).getXChord() * 32, ((Tile) arg).getYChord() * 32);
		//map.drawMap();
		//img = map.getMapImage();
		list.clear();
		for(Agent agent: map.getAgents()){
			String element = agent.getName();
			list.addElement(element);
		}
		repaint();
		wrapper.setViewportView(new JViewport().add(panel));
		System.out.println("Tile was changed");
		
	}

}
