package main;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Responsible for taking the file and separating it into parts that more
 * specialized classes can use.
 */
public class Parser {

	public Parser() {

	}

	char def;

	public void parseHeader(byte[] file) throws Exception {
		if (file.length < 128)
			throw new IOException("file does not contain header!");

		byte[] headerList = Arrays.copyOfRange(file, 0, 128);

		// DWORD File size
		int size = SpecConverter.toDWORD(Arrays.copyOfRange(headerList, 0, 4));
		Logger.log(1, "file size: " + size + " bytes");

		// WORD Magic number (0xA5E0)
		char magicNumber = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 4, 6)));
		if (magicNumber != 0xA5E0) {
			// non fatal error so will continue parsing
			Logger.log(2, "Magic number is not correct! Is this a .aseprite file?");
		} else {
			Logger.log(1, "magic number: " + Integer.toHexString(magicNumber));
		}

		// WORD Frames
		char frames = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 6, 8)));
		Logger.log(1, "frames: " + (int) frames);

		// WORD Width in pixels
		char width = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 8, 10)));
		Logger.log(1, "width: " + (int) width + " pixels");

		// WORD Height in pixels
		char height = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 10, 12)));
		Logger.log(1, "height: " + (int) height + " pixels");

		// WORD Color Depth
		char colorDepth = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 12, 14)));
		Logger.log(1, "color depth: " + (int) colorDepth + " bpp");

		// DWORD Flags
		int flags = (char) (SpecConverter.toDWORD(Arrays.copyOfRange(headerList, 14, 18)));
		Logger.log(1, "flags: " + (int) flags);

		// WORD Speed (Depricated)
		char speed = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 18, 20)));
		Logger.log(1, "speed(depricated): " + (int) speed + "ms");

		// BYTE Palette entry (index) which represent transparent color
		int indexOfTransparency = SpecConverter.toBYTE(headerList[28]);
		Logger.log(1, "transparency index: " + indexOfTransparency);

		// WORD Number of colors (0 means 256 for old sprites)
		char colors = (char) (SpecConverter.toWORD(Arrays.copyOfRange(headerList, 32, 34)));
		if (colors == 0) {
			colors = 256;
		}
		Logger.log(1, "colors: " + (int)colors);

		// BYTE Pixel width (pixel ratio is "pixel width/pixel height").
		int pixelWidth = SpecConverter.toBYTE(headerList[34]);
		Logger.log(1, "pixel width: " + pixelWidth);
		
		// BYTE  Pixel height
		int pixelHeight = SpecConverter.toBYTE(headerList[35]);
		Logger.log(1, "pixel height: " + pixelHeight);
	}

}
