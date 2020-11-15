import java.io.Serializable;
import java.util.Random;

/**
 * This class creates a tile instance that is defined by its shape
 * and color
 * @author gerne
 *
 */
public class Tile implements Serializable{
	// Following variables define color and shape type
	private String shapeColor;
	private String shapeType;
	
	// Following functions allow access to each private variable
	public String getShapeColor() {
		return shapeColor;
	}
	public String getShapeType() {
		return shapeType;
	}
	
	/**
	 * This function sets the color of the tile.
	 * @param color Color of tile as string
	 */
	public void setShapeColor(String color) {
		shapeColor = color;
	}
	/**
	 * This function sets the shape of the tile.
	 * @param type Shape of tile as string
	 */
	public void setShapeType(String type) {
		shapeType = type;
	}
	
	/**
	 * Default constructor that sets up a default panel.
	 */
	public Tile() {
		shapeColor = "YELLOW";
		shapeType = "circle";
	}
	
	/**
	 * Non-default constructor that takes in color and shape type to
	 * create a tile.
	 * @param color The color of the tile as a string.
	 * @param type The shape of the tile as a string.
	 */
	public Tile(String color, String type) {
		setShapeColor(color);
		setShapeType(type);
	}
	
	/**
	 * This function chooses random integers between 0 and 1 and between
	 * 0 and 4 in order in order to randomly set the shape and color
	 * of the tile respectively.
	 */
	public void setRandomly() {
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
	
	/**
	 * This function overrides the toString() method so that the tile
	 * will print out its color and type.
	 */
	@Override
	public String toString() {
		return String.format("%s %s", shapeColor, shapeType);
	}
	
}
