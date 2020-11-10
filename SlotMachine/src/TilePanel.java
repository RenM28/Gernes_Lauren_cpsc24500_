import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TilePanel extends JPanel implements MouseListener, MouseMotionListener {
	private String mouseStatus;
	private ArrayList<Tile> tiles;
	// where do I initialize the individual tiles?
	// Should i make them their own variables?
	// Or should I make a list and somewhere specify the values?
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	
	public TilePanel() {
		mouseStatus = "Welcome!";
		addMouseListener(this);
		addMouseMotionListener(this);
		tiles = new ArrayList<Tile>();
		tiles.add(new Tile(25, "YELLOW", "circle"));
		tiles.add(new Tile(225, "BLUE", "square"));
		tiles.add(new Tile(425, "RED", "square"));
		tiles.add(new Tile(625, "RED", "square"));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tileDim = 150;
		int tileTop = 25;
		for (Tile tile: tiles) {
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
				g.fillOval(tile.getX(), tileTop, tileDim, tileDim);
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
				g.fillRect(tile.getX(), tileTop, tileDim, tileDim);
			}
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
	public void mouseClicked(MouseEvent e) { 
		mouseStatus = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());
		if ((e.getX() >= 25 && e.getX() <= 175) && (e.getY() >= 25 && e.getY() <= 175)) {
			tiles.get(0).setRandomly();
			System.out.println(tiles.get(0));
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
