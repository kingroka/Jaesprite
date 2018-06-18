package main;

public class SpecConverter {
	/**
	 * converts java byte to aseprite format unsigned BYTE
	 * @param num
	 *            byte to be unsigned
	 * @return the unsigned version of the BYTE
	 */
	public static int toBYTE(byte num) {
		return num & 0xFF;
	}
	
	/**
	 * Converts byte array to aseprite format WORD
	 * @param num
	 * 		array to be converted
	 * @return integer with converted WORD
	 */
	public static int toWORD(byte[] num) {
		int newNum = 0;
		for(int i= 0; i < 2; i++) {
			newNum = newNum | (toBYTE(num[i]) << (i * 8));
		}
		return newNum;
	}
	
	/**
	 * Converts byte array to aseprite format SHORT
	 * @param short
	 * 		array to be converted
	 * @return integer with converted SHORT
	 */
	public static int toSHORT(byte[] num) {
		int newNum = 0;
		for(int i= 0; i < 2; i++) {
			newNum = newNum | (num[i]) << (i * 8);
		}
		return newNum;
	}
	
	/**
	 * Converts byte array to aseprite format DWORD
	 * @param num
	 * 		array to be converted
	 * @return integer with converted DWORD
	 */
	public static int toDWORD(byte[] num) {
		int newNum = 0;
		for(int i= 0; i < 4; i++) {
			newNum = newNum | (toBYTE(num[i]) << (i * 8));
		}
		return newNum;
	}
	
	/**
	 * Converts byte array to aseprite format LONG
	 * @param short
	 * 		array to be converted
	 * @return integer with converted LONG
	 */
	public static int toLONG(byte[] num) {
		int newNum = 0;
		for(int i= 0; i < 4; i++) {
			newNum = newNum | (num[i]) << (i * 8);
		}
		return newNum;
	}
	
	/**
	 * Converts byte array to aseprite format BYTE array
	 * @param num
	 * 		array to be converted
	 * @return integer with converted BYTE array
	 */
	public static int[] toBYTEN(byte[] num) {
		int[] newNum = new int[num.length];
		for(int i= 0; i < num.length; i++) {
			newNum[i] = toBYTE(num[i]);
		}
		return newNum;
	}
	
}
