import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TileWriter {
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f, tiles);
	}
	
	public boolean writeToText(File f, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Tile tile: tiles) {
				pw.println(tile);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
