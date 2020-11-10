import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> tilesRead = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int x;
			String color, type;
			Tile tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				x = Integer.parseInt(parts[0]);
				color = parts[1];
				type = parts[2];
				tile = new Tile(x, color, type);
				tilesRead.add(tile);
			}
			fsc.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
}
