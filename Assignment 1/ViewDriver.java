package textviewer;
/**
 * @author CS 442 / CS 542
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ViewDriver {
	private JPanel control = new JPanel();
	private DisplayPanel txtDisplay = new DisplayPanel();
	private JTextArea txtArea = new JTextArea(5,20);
	private JFrame frame = new JFrame();
	private Container content = frame.getContentPane();
	private RawBlockLayout blockLayout = new RawBlockLayout();
	private Block[][] blockArray;
	
	// dynamically modified algorithm
	private Modifier layoutModifier = LazyModifier.createModifier();
	
	int screenWidth;
	int screenHeight;

	public ViewDriver() {
	}
	private void findScreenSize(){
		Toolkit tlkt = Toolkit.getDefaultToolkit();
		Dimension screenDim = tlkt.getScreenSize();
		screenWidth = screenDim.width;
		screenHeight = screenDim.height;
	}
	public void doExit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame, "Do you really wish to exit?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void handleFontField(JTextField fontSize) {
		try {
			DataStore.getHandle().setFontSize(Integer.parseInt(fontSize.getText()));
			doMoveTextUp();
		} catch (Exception ex) {
			Toolkit.getDefaultToolkit().beep();
			fontSize.selectAll();				
		}					
	}
	private void doMoveTextUp() {
		Font font = DataStore.getHandle().getFont();
		txtDisplay.setFont(font);
		FontMetrics fontMetrics = frame.getFontMetrics(font);			
		Block[] wordBlocks = BlockDecomposer.decompose(txtArea.getText(), fontMetrics);
		blockArray = blockLayout.locateAll(wordBlocks, txtDisplay);
		blockArray = layoutModifier.modify(blockArray, txtDisplay.getDisplayPanelWidth());
		txtDisplay.setContent(blockArray);
		txtDisplay.repaint();
	}
	private void makeControlNorth(Container c) {
		JPanel topBar = new JPanel();
		JPanel topBarUp = new JPanel();
		JPanel topBarDown = new JPanel();
		topBar.setLayout(new GridLayout(2,1));
		topBar.add(topBarUp);
		topBar.add(topBarDown);
		JLabel label = new JLabel("  Font size: "); 
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		topBarUp.add(label);
		JButton b;
		final JTextField fontSize = new JTextField(3);
		topBarUp.add(fontSize);
		fontSize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				handleFontField(fontSize);
			}
		});
		label = new JLabel("enter a number and hit enter or press:");
		label.setBackground(Color.LIGHT_GRAY);
		topBarUp.add(label);
		b = new JButton("OK");
		b.setBackground(Color.LIGHT_GRAY);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFontField(fontSize);
			}
		});
		topBarUp.add(b);
		b = new JButton("Change text color");
		b.setBackground(Color.LIGHT_GRAY);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(
						frame,
						"Choose Text Color",
						DataStore.getHandle().getTextColor());
				if (newColor != null) {
					DataStore.getHandle().setTextColor(newColor);
				}
				frame.repaint();
			}
		});
		topBarDown.add(b);
		b = new JButton("Change background");
		b.setBackground(Color.LIGHT_GRAY);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(
						frame,
						"Choose Text Color",
						DataStore.getHandle().getBackgroundColor());
				if (newColor != null) {
					DataStore.getHandle().setBackgroundColor(newColor);
				}
				frame.repaint();
			}
		});
		topBarDown.add(b);
		c.add(topBar, BorderLayout.PAGE_START);
	}
	private void makeControlSouth(Container c) {
		JPanel bottomBar = new JPanel();
		JPanel bottomBarUp = new JPanel();
		JPanel bottomBarDown = new JPanel();
		bottomBar.setLayout(new GridLayout(2,1));
		bottomBar.add(bottomBarUp);
		bottomBar.add(bottomBarDown);
		JButton b;
		bottomBarUp.add(b = new JButton("MoveText up"));
		b.addActionListener(e -> doMoveTextUp());
		bottomBarUp.add(b = new JButton("Exit"));
		b.addActionListener(e -> doExit());	
		bottomBarDown.add(b = new JButton("Left Justify"));
		b.addActionListener(e -> {
			layoutModifier = LazyModifier.createModifier();
			doMoveTextUp();
		});
		bottomBarDown.add(b = new JButton("Right Justify"));
		b.addActionListener(e -> 
		{
			layoutModifier = RightModifier.createModifier();					
			doMoveTextUp();
		});
		bottomBarDown.add(b = new JButton("Center Justify"));
		b.addActionListener(e -> 
		{
			layoutModifier = CenterModifier.createModifier();					
			doMoveTextUp();
		});
		bottomBarDown.add(b = new JButton("Fully Justify"));
		b.addActionListener(e -> {
			layoutModifier = FullModifier.createModifier();	
			doMoveTextUp();
		});
		c.add(bottomBar, BorderLayout.PAGE_END);
	}
	private void makeLowerPart() {
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		control.setBorder(compound);
		control.setLayout(new BorderLayout());
		makeControlNorth(control);
		txtArea.setText("System.copyArray: " +
				"Copies an array from the specified source array, " +
				"beginning at the specified position, to the " +
				"specified position of the destination array. " +
				"A subsequence of array components are copied from " + 
				"the source array referenced by src to the destination " +
				"array referenced by dest. The number of components copied " +
				"is equal to the length argument. The components " +
				"at positions srcPos through srcPos+length-1 in the " +
				"in the source array are copied into positions destPos " +
				"through destPos+length-1, respectively, of the " +
				"destination array."); 
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		JScrollPane scroller = new JScrollPane(txtArea);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		control.add(scroller, BorderLayout.CENTER);
		makeControlSouth(control);
	}
	public void init() {
		findScreenSize();
		makeLowerPart();
		content.setLayout(new BorderLayout());
		content.add(txtDisplay);
		content.add(control, BorderLayout.PAGE_END);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(WindowListenerFactory.windowClosingFactory(e -> doExit()));
		frame.pack();
		frame.setSize(Math.max(frame.getWidth(), screenWidth/2), 
				Math.max(frame.getHeight(), 3*screenHeight/4));
		frame.setLocationRelativeTo(null); // centered
		frame.setVisible(true);	
	}
	public static void main(String[] args) {		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewDriver viewDriver = new ViewDriver();
				viewDriver.init();
			}
		});
	}
}
