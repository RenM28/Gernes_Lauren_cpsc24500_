import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class sets up an array of 4 Tile instances as a panel.
 * Each tile can be randomly changed when clicked.
 * @author gerne
 *
 */
public class TilePanel extends JPanel implements MouseListener, MouseMotionListener {
	// sets up mouse and array of tiles
	private String mouseStatus;
	private ArrayList<Tile> tiles;
	
	// allows access to private array of tiles
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	/**
	 * This function sets up the array of tiles.
	 * @param tiles Tile array
	 */
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	
	/**
	 * This constructor sets up an initial tile panel with 4 tiles
	 * of specified shape and color.
	 */
	public TilePanel() {
		mouseStatus = "Welcome!";
		addMouseListener(this);
		addMouseMotionListener(this);
		tiles = new ArrayList<Tile>();
		tiles.add(new Tile("YELLOW", "circle"));
		tiles.add(new Tile("BLUE", "square"));
		tiles.add(new Tile("RED", "square"));
		tiles.add(new Tile("RED", "square"));
	}
	
	/**
	 * This function overrides the paint component so that tiles will be 
	 * drawn based on their shape and color.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tileDim = 150; // width + height of tile
		int tileTop = 25;  // starting point of top of tile 
		int x = 25;		   // starting point of left of tile for first tile
		for (Tile tile: tiles) { // for each tile
			if (tile.getShapeType().equals("circle")) {
				if (tile.getShapeColor().equals("YELLOW")) {
					g.setColor(Color.YELLOW);
				} else if (tile.getShapeColor().equals("GREEN")) {
					g.setColor(Color.GREEN);
				} else if (tile.getShapeColor().equals("ORANGE")) {
					g.setColor(Color.ORANGE);
				} else if (tile.getShapeColor().equals("RED")) {
					g.setColor(Color.RED);
				} else {
					g.setColor(Color.BLUE);
				}
				g.fillOval(x, tileTop, tileDim, tileDim);
			} else {
				if (tile.getShapeType().equals("YELLOW")) {
					g.setColor(Color.YELLOW);
				} else if (tile.getShapeColor().equals("GREEN")) {
					g.setColor(Color.GREEN);
				} else if (tile.getShapeColor().equals("ORANGE")) {
					g.setColor(Color.ORANGE);
				} else if (tile.getShapeColor().equals("RED")) {
					g.setColor(Color.RED);
				} else {
					g.setColor(Color.BLUE);
				}
				g.fillRect(x, tileTop, tileDim, tileDim);
			}
			x += 200; // increments left starting point
		}
	}
	// Mouse commands 
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	public void mouseEntered(MouseEvent e) { 
		mouseStatus = "Entered the window.";
		repaint();
	}
	public void mouseExited(MouseEvent e) {
		mouseStatus = "Exited the window.";
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("Mouse pressed at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("Mouse released at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	/**
	 * When the mouse is clicked within the range of a certain tile, 
	 * its shape and color will be changed randomly.
	 */
	public void mouseClicked(MouseEvent e) { 
		mouseStatus = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());
		if ((e.getX() >= 25 && e.getX() <= 175) && (e.getY() >= 25 && e.getY() <= 175)) {
			tiles.get(0).setRandomly();
		} 
		
		if ((e.getX() >= 225 && e.getX() <= 375) && (e.getY() >= 25 && e.getY() <= 175)) {
			tiles.get(1).setRandomly();
		}
		
		if ((e.getX() >= 425 && e.getX() <= 575) && (e.getY() >= 25 && e.getY() <= 175)) {
			tiles.get(2).setRandomly();
		}
		
		if ((e.getX() >= 625 && e.getX() <= 775) && (e.getY() >= 25 && e.getY() <= 175)) {
			tiles.get(3).setRandomly();
		}
		repaint();
	}
	public void mouseMoved(MouseEvent e) { 
		mouseStatus = String.format("Mouse moved at (%d, %d)", e.getX(), e.getY());
		repaint();
		
	}
	public void mouseDragged(MouseEvent e) { 
		mouseStatus = String.format("Mouse dragged at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
}
