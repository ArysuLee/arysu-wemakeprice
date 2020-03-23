package net.arysu.wemakeprice;

import java.util.Iterator;

public class SortedCharacterIterator implements Iterator<String> {

	private static String[] SORTED_STRING = new String[] { "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f",
			"G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q",
			"q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z" };

	private int[] numericCounter;
	private int[] alphabetCounter;
	private int index;
	private int total;

	public SortedCharacterIterator(int[] numericCounter, int[] alphabetCounter) {
		this.numericCounter = numericCounter;
		this.alphabetCounter = alphabetCounter;
		this.index = 0;

		for (int count : numericCounter) {
			total += count;
		}

		for (int count : alphabetCounter) {
			total += count;
		}
	}

	@Override
	public boolean hasNext() {
		if (index == 0 && total > 0) {
			return true;
		} else if (index < total) {
			return true;
		}
		return false;
	}

	@Override
	public String next() {

		String string = null;

		if (index % 2 == 0) { // alpahbet

			string = findAlphabet();
			if (string == null) {
				string = findNumeric();
			}

		} else { // numeric

			string = findNumeric();
			if (string == null) {
				string = findAlphabet();
			}
		}

		index++;

		return string;
	}

	private String findNumeric() {

		int pIndex = -1;
		for (int i = 0; i < numericCounter.length; i++) {
			if (numericCounter[i] > 0) {
				pIndex = i;
				break;
			}
		}

		String string = null;
		if (pIndex != -1) {
			numericCounter[pIndex]--;
			string = "" + pIndex;
		}

		return string;
	}

	private String findAlphabet() {

		int pIndex = -1;
		for (int i = 0; i < alphabetCounter.length; i++) {
			if (alphabetCounter[i] > 0) {
				pIndex = i;
				break;
			}
		}

		String string = null;
		if (pIndex != -1) {
			alphabetCounter[pIndex]--;
			string = SORTED_STRING[pIndex];
		}

		return string;
	}

}
