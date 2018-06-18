package main;

public class Main {
	/**
	 * Used for debugging and development.
	 */

	public static void main(String[] args) {
		FileLoader loader = new FileLoader();
		byte[] file = loader.loadFileAsByteArray("./src/res/test.aseprite");
		Parser parser = new Parser();
		try {
			parser.parseHeader(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
