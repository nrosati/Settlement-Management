import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameClient extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame = new JFrame("Athens: Build an Empire");
	public JPanel boxWest = new JPanel();
	public JPanel resourceBox = new JPanel();
	
	
	public JPanel boxButton = new JPanel();
	public JPanel boxListAgents = new JPanel();
	public JPanel boxMap = new JPanel();
	public JPanel boxListBuidings = new JPanel();
	
	public JPanel resourceGold = new JPanel();
	public JPanel resourceFaith = new JPanel();
	public JPanel resourceFood = new JPanel();
	public JPanel resourceWood = new JPanel ();
	public JPanel resourcePop = new JPanel();
	
	public JPanel imageGold = new JPanel();
	public JPanel imageFaith = new JPanel();
	public JPanel imageFood = new JPanel();
	public JPanel imageWood = new JPanel();
	public JPanel imagePop = new JPanel();
	
	
	public JButton collectorButton = new JButton("Collector");
	public JButton hopliteButton = new JButton("Hoplite");
	public JButton priestButton = new JButton("Priest");
	
	public JLabel labelGold = new JLabel("Gold");
	public JLabel labelFaith = new JLabel("Faith");
	public JLabel labelFood = new JLabel("Food");
	public JLabel labelWood = new JLabel("Wood");
	public JLabel labelPop = new JLabel("Population");
	
	
	public JLabel listAgents = new JLabel("List of Agents");
	public JLabel listBuildings = new JLabel("List of Buildings");
	public JLabel labelMap = new JLabel("Map");
	
	public JButton box = new JButton();
	
	private Timer timer;
	private Container cont;
	
	
	
	public void view() {
		
		
		
		//resourceBox.getRootPane().setLayout(new FlowLayout());
		//resourceBox.getRootPane().add(new JLabel(new ImageIcon("images/greek.jpg")));
	
		
		JLabel athens = new JLabel("Athens");
		JLabel resources = new JLabel("Resources");
		
		JPanel client = new JPanel();
		
		//ImageIcon iconLogo = new ImageIcon("Images/greek.jpg", null);
		
		JLabel resourcePattern = new JLabel();
		//boxWest.setLayout(new BoxLayout(boxWest, BoxLayout.PAGE_AXIS));
		// This is an empty content area in the frame
		//JLabel client = new JLabel("");
		
		
		//change values to add buttons
		resourceBox.setPreferredSize(new Dimension(300,100));
		resourceBox.setBackground(Color.GRAY);
		//resourcePattern.add(iconLogo);
		//resourceBox.add(pattern);
		
		resourceGold.setPreferredSize(new Dimension(200, 100));
		resourceFaith.setPreferredSize(new Dimension(200, 100));
		resourceFood.setPreferredSize(new Dimension(200, 100));
		resourceWood.setPreferredSize(new Dimension(200, 100));
		resourcePop.setPreferredSize(new Dimension(200, 100));
		
		
		imageGold.setPreferredSize(new Dimension(10, 10));
		imageFaith.setPreferredSize(new Dimension(10, 10));
		imageWood.setPreferredSize(new Dimension(10, 10));
		imageFood.setPreferredSize(new Dimension(10, 10));
		imagePop.setPreferredSize(new Dimension(10, 10));
		
		
		resourceGold.setBackground(Color.MAGENTA);
		resourceFaith.setBackground(Color.MAGENTA);
		resourceFood.setBackground(Color.MAGENTA);
		resourceWood.setBackground(Color.MAGENTA);
		resourcePop.setBackground(Color.MAGENTA);
		
		resourceBox.add(resourceGold, BorderLayout.WEST);
		resourceGold.add(labelGold);
		resourceFaith.add(labelFaith);
		resourceFood.add(labelFood);
		resourceWood.add(labelWood);
		resourcePop.add(labelPop);
		
		resourceBox.add(resourcePop, BorderLayout.WEST);
		resourceBox.add(resourceFaith, BorderLayout.WEST);
		resourceBox.add(resourceFood, BorderLayout.WEST);
		resourceBox.add(resourceWood, BorderLayout.WEST);
		
		resourcePop.add(imagePop, BorderLayout.WEST);
		resourceGold.add(imageGold, BorderLayout.WEST);
		resourceFaith.add(imageFaith, BorderLayout.WEST);
		resourceFood.add(imageFood, BorderLayout.WEST);
		resourceWood.add(imageWood, BorderLayout.WEST);
		
		imageGold.setBackground(Color.YELLOW);
		imageFaith.setBackground(Color.BLUE);
		imageFood.setBackground(Color.RED);
		imagePop.setBackground(Color.WHITE);
	
		imageWood.setBackground(brown());
		
		frame.add(resourceBox, BorderLayout.NORTH);
		boxWest.setPreferredSize(new Dimension(300,200));
		
		
		
		boxListAgents.setPreferredSize(new Dimension(300, 320)); // List of Buildings
		
		boxListBuidings.setPreferredSize(new Dimension(300, 180));
		
		boxButton.setPreferredSize(new Dimension(300, 100));// change to add buttons, 300 the side
		
		boxMap.setPreferredSize(new Dimension(300, 150));
		
		/*
		boxWestMid1.setPreferredSize(new Dimension(100,50));
		boxWestNorth1.setPreferredSize(new Dimension(100, 50));
		boxWestSouth1.setPreferredSize(new Dimension(100, 50));
		
		boxWestMid2.setPreferredSize(new Dimension(100,50));
		boxWestNorth2.setPreferredSize(new Dimension(100, 50));
		boxWestSouth2.setPreferredSize(new Dimension(100, 50));
		
		boxWestMid3.setPreferredSize(new Dimension(100,50));
		boxWestNorth3.setPreferredSize(new Dimension(100, 50));
		boxWestSouth3.setPreferredSize(new Dimension(100, 50));
		*/
		
		collectorButton.setPreferredSize(new Dimension(200, 300));
		hopliteButton.setPreferredSize(new Dimension(200, 300));
		priestButton.setPreferredSize(new Dimension(200, 300));
		
		boxButton.add(collectorButton, BorderLayout.WEST);
		boxButton.add(hopliteButton, BorderLayout.CENTER);
		boxButton.add(priestButton, BorderLayout.EAST);
		
		
		
		
		boxButton.setLayout(new GridLayout(1, 2));
		/*
		JButton buildCollector = new JButton("Build Collector");
		JButton buildPriest = new JButton("Build Priest");
		JButton buildWarrior = new JButton("Build Hoplite");
		
		boxWest.setLayout(new GridLayout(3, 4));
		
		boxWest.add(buildWarrior);
		boxWest.add(buildPriest);
		boxWest.add(buildCollector);
		*/
		//box1.setPreferredSize(new Dimension(200,100));
		boxWest.setBackground(Color.GRAY);
		//boxWest.add(resources, BorderLayout.WEST);
		boxListAgents.setBackground(Color.GRAY);
		boxButton.setBackground(Color.CYAN);
		boxMap.setBackground(Color.MAGENTA);
		boxListBuidings.setBackground(Color.MAGENTA);
	
		boxWest.add(boxListAgents, BorderLayout.WEST);
		boxWest.add(boxButton, BorderLayout.NORTH);
		boxWest.add(boxMap, BorderLayout.SOUTH);
		boxWest.add(boxListBuidings, BorderLayout.WEST);
		
		boxListAgents.add(labelMap);
		boxMap.add(listAgents);
		boxListBuidings.add(listBuildings);
		
		/*
		boxWestMid1.setBackground(Color.BLUE);
		boxWestNorth1.setBackground(Color.RED);
		boxWestSouth1.setBackground(Color.YELLOW);
		
		boxWestMid.add(boxWestMid1, BorderLayout.WEST);
		boxWestNorth.add(boxWestNorth1, BorderLayout.NORTH);
		boxWestSouth.add(boxWestSouth1, BorderLayout.SOUTH);
		
		boxWestMid.add(boxWestMid2, BorderLayout.WEST);
		boxWestNorth.add(boxWestNorth2, BorderLayout.NORTH);
		boxWestSouth.add(boxWestSouth2, BorderLayout.SOUTH);
		
		boxWestMid1.setBackground(Color.BLUE);
		boxWestNorth1.setBackground(Color.RED);
		boxWestSouth1.setBackground(Color.YELLOW);
		
		boxWestMid.add(boxWestMid3, BorderLayout.WEST);
		boxWestNorth.add(boxWestNorth3, BorderLayout.NORTH);
		boxWestSouth.add(boxWestSouth3, BorderLayout.SOUTH);
		
		boxWestMid2.setBackground(Color.BLACK);
		boxWestNorth2.setBackground(Color.YELLOW);
		boxWestSouth2.setBackground(Color.BLUE);
		
		boxWestMid3.setBackground(Color.RED);
		boxWestNorth3.setBackground(Color.GREEN);
		boxWestSouth3.setBackground(Color.BLUE);
		*/
		
		
		
		//boxWestMid.add(athens, BorderLayout.CENTER);
		//boxWest.add(athens, BorderLayout.SOUTH);
		
		frame.add(boxWest, BorderLayout.EAST);
		
		
		
		//frame.setLayout(new LayoutManager());
		
		
		frame.setPreferredSize(new Dimension(1200, 1000));
		//frame.getContentPane().add(client, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		initComponent();
		
		
		
	}
	
	public Color brown() {
		Color brown = new Color(129, 80, 51);
		
		return brown;
		
	}

	private void initComponent() {
        //mainPanel = new JPanel();
          frame.addMouseListener(new ClickListener());
          cont = getRootPane();
          cont.add(frame);
          frame.setBackground(Color.WHITE);
          timer = new Timer(3000,this);//3 Secs
}
	
	class ClickListener extends MouseAdapter      {
        public void mouseClicked(MouseEvent e) {
                      if(! timer.isRunning() && e.getSource()==boxWest) {
                            frame.setBackground(Color.BLACK);
                            timer.start();
                      }
         }
}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 timer.stop();
         frame.setBackground(Color.WHITE);
         repaint();//Repaint frame
		
	}
}
	


/*
class ClickListener extends MouseAdapter      {
    public void mouseClicked(MouseEvent e) {
                  if(! timer.isRunning() && e.getSource()==mainPanel) {
                        frame.setBackground(Color.BLACK);
                        timer.start();
                  }
     }
    
    private Color getRandomColor() {
		// TODO Auto-generated method stub
		//Double hue  = Math.random();
		//Float rgb = Color.HSBtoRGB(hue,0.5,0.5);
		//Color color = new Color(rgb);
		
		Color color;
		Random random = new Random();
		final float hue = random.nextFloat();
		final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
		final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
		return color = Color.getHSBColor(hue, saturation, luminance);
	}
    public void actionPerformed
	(ActionEvent evt) {
	boxWestNorth3.setForeground(getRandomColor());
	boxWestMid3.setForeground(getRandomColor());
	boxWestSouth3.setForeground(getRandomColor());
	
	boxWestNorth2.setForeground(getRandomColor());
	boxWestMid2.setForeground(getRandomColor());
	boxWestSouth2.setForeground(getRandomColor());
	
	boxWestNorth1.setForeground(getRandomColor());
	boxWestMid1.setForeground(getRandomColor());
	boxWestSouth1.setForeground(getRandomColor());
	
	
}

*/


    


	

