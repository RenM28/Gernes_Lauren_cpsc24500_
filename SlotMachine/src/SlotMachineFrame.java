import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SlotMachineFrame extends JFrame{
	private TilePanel pan;
	/**
	 * This function allows the frame to be centered on the screen.
	 * @param width The width of the frame as an integer
	 * @param height The height of the frame as an integer
	 */
	public void centerFrame(int width, int height) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDims = tk.getScreenSize();
		int screenWidth = (int)screenDims.getWidth();
		int screenHeight = (int)screenDims.getHeight();
		int left = (screenWidth - width)/2;
		int top = (screenHeight - height)/2;
		setBounds(left, top, width, height);
	}
	
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		mbar.add(mnuFile);
		
		JMenuItem miLoadTiles = new JMenuItem("Load Tiles");
		miLoadTiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr;
				ArrayList<Tile> tilesRead;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tr = new TileReader();
					tilesRead = tr.readFromText(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null, "Could not read tiles.");
					} else {
						pan.setTiles(tilesRead);
						repaint();
					}
				}
			}
		});
		mnuFile.add(miLoadTiles);
		
		JMenuItem miSaveTiles = new JMenuItem("Save Tiles");
		miSaveTiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw;
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					tw = new TileWriter();
					if (tw.writeToText(jfc.getSelectedFile(), pan.getTiles())) {
						JOptionPane.showMessageDialog(null, "Tiles were written :)");
					} else {
						JOptionPane.showMessageDialog(null, "Tiles could not be written :(");
					}
				}
				
			}
		});
		mnuFile.add(miSaveTiles);
		
		JMenuItem miPrint = new JMenuItem("Print");
		miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnuFile.add(miPrint);
		
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnuFile.add(miRestart);
		
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnuFile.add(miExit);
		
		JMenu mnuHelp = new JMenu("Help");
		mbar.add(mnuHelp);
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Author: Ren Gernes, URL: https://github.com/RenM28/Gernes_Lauren_cpsc24500_");
			}
		});
		mnuHelp.add(miAbout);
		setJMenuBar(mbar);
		
	}
	
	public void setupLook() {
		centerFrame(820,330); 
		setTitle("Las Vegas Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new TilePanel();
		c.add(pan, BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnMax = new JButton("Max");
		panSouth.add(btnMax);
		JButton btnMid = new JButton("Mid");
		panSouth.add(btnMid);
		JButton btnMin = new JButton("Min");
		panSouth.add(btnMin);
		panSouth.add(new JLabel("$"));
		JTextField txtBalance = new JTextField(6);
		panSouth.add(txtBalance);
		c.add(panSouth, BorderLayout.SOUTH);
		setupMenu();
	}
	
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
