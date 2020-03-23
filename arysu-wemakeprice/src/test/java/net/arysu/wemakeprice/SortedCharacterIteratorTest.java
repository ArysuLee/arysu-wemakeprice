package net.arysu.wemakeprice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SortedCharacterIteratorTest {

	private SortedCharacterIterator iter;
	
	@Test
	void test1() {
		
		int[] numericCounter = makeNumeric1();
		int[] alphabetCounter = makeAlphabet1();
		iter = new SortedCharacterIterator(numericCounter, alphabetCounter);
		String scs = createString();
		
		assertEquals("A0a1B2b3C4c5D6d7E8e9FfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz", scs);
	}

	@Test
	void test2() {
		
		int[] numericCounter = makeNumeric2();
		int[] alphabetCounter = makeAlphabet2();
		iter = new SortedCharacterIterator(numericCounter, alphabetCounter);
		String scs = createString();
		
		assertEquals("E2E2F2F5F8F8FggggggggiiiUUUU", scs);
	}
	
	private String createString() {
		StringBuilder sb = new StringBuilder();
		while (iter.hasNext()) {
			sb.append(iter.next());
		}
		return sb.toString();
	}
	
	int[] makeNumeric1() {
		int[] numericCounter = new int[10];
		for (int i = 0; i < 10; i++) {
			numericCounter[i] = 1;
		}
		return numericCounter;
	}
	
	int[] makeNumeric2() {
		int[] numericCounter = new int[10];
		numericCounter[2] = 3;
		numericCounter[5] = 1;
		numericCounter[8] = 2;
		return numericCounter;
	}
	
	int[] makeAlphabet1() {
		int[] alphabetCounter = new int[52];
		for (int i = 0; i < 52; i++) {
			alphabetCounter[i] = 1;
		}
		return alphabetCounter;
	}
	
	int[] makeAlphabet2() {
		int[] alphabetCounter = new int[52];
		alphabetCounter[8] = 2;
		alphabetCounter[10] = 5;
		alphabetCounter[13] = 8;
		alphabetCounter[17] = 3;
		alphabetCounter[40] = 4;
		return alphabetCounter;
	}

}
