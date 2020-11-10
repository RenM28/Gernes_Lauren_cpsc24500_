import java.util.Random;

public class Tile {
	// what to do with set type, set color, and random 
	// really confused here because user won't ever enter anything
	private String shapeColor;
	private String shapeType;
	private int x;
	
	public int getX() {
		return x;
	}
	public String getShapeColor() {
		return shapeColor;
	}
	public String getShapeType() {
		return shapeType;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setShapeColor(String color) {
		shapeColor = color;
	}
	
	public void setShapeType(String type) {
		shapeType = type;
	}
	
	// Default constructor
	public Tile() {
		x = 0;
		shapeColor = "YELLOW";
		shapeType = "circle";
	}
	
	public Tile(int xPos, String color, String type) {
		// type, color = setRandomly();
		setX(xPos);
		setShapeColor(color);
		setShapeType(type);
	}
	// will change color and shape randomly
	public void setRandomly() {
		// another possibility, return array of random nums
		// and call in tile
		Random rand = new Random();
		int rndType = rand.nextInt(2);
		int rndShape = rand.nextInt(5);
		
		if (rndShape == 0) {
			shapeColor = "YELLOW";
		} else if (rndShape == 1) {
			shapeColor = "GREEN";
		} else if (rndShape == 2) {
			shapeColor = "ORANGE";
		} else if (rndShape == 3) {
			shapeColor = "RED";
		} else {
			shapeColor = "BLUE";
		}
		
		if (rndType == 0) {
			shapeType = "circle";
		} else {
			shapeType = "square";
		}
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s", x, shapeColor, shapeType);
	}
	
}
