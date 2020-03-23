package net.arysu.wemakeprice;

import java.io.ByteArrayOutputStream;

public class ByteHolder {

	private ByteArrayOutputStream numericBaos = new ByteArrayOutputStream();
	private ByteArrayOutputStream alphabetLowerBaos = new ByteArrayOutputStream();
	private ByteArrayOutputStream alphabetUpperBaos = new ByteArrayOutputStream();
	
	public void writeNumeric(int data) {
		numericBaos.write(data);
	}
	
	public void writeLowerAlphabet(int data) {
		alphabetLowerBaos.write(data);
	}
	
	public void writeUpperAlphabet(int data) {
		alphabetUpperBaos.write(data);
	}
	
	public byte[] toNumericByteArray() {
		return numericBaos.toByteArray();
	}
	
	public byte[] toLowerAlphabetByteArray() {
		return alphabetLowerBaos.toByteArray();
	}
	
	public byte[] toUpperAlphabetByteArray() {
		return alphabetUpperBaos.toByteArray();
	}

	public static boolean isLowerAlphabet(int data) {
		return data >= 97 && data <= 122 ;
	}
	
	public static boolean isUpperAlphabet(int data) {
		return data >= 65 && data <= 90;
	}

	public static boolean isNumeric(int data) {
		return data >= 48 && data <= 57;
	}
}
