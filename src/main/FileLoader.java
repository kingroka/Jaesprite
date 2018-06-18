package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *  Used to load and manipulate files and is not used for parsing.
 */
public class FileLoader {
	
	public FileLoader() {

	}

	/**
	 * @param path absolute path to the file
	 * @return byte array containing file data
	 *
	 */
	public byte[] loadFileAsByteArray(String path) {
		Path path1 = Paths.get(path);
		try {
			Logger.log(1, "loaded: " + path);
			return Files.readAllBytes(path1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
