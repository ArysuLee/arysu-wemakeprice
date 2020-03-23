package net.arysu.wemakeprice;

import org.springframework.stereotype.Component;

@Component
public class CharacterSorter {

	public String sort(ByteHolder holder) {
		
		byte[] numerics = holder.toNumericByteArray();
		byte[] lowerAlphabets = holder.toLowerAlphabetByteArray();
		byte[] upperAlphabets = holder.toUpperAlphabetByteArray();
		
		int[] numericCounter = new int[10];
		
		for (byte numeric : numerics) { 
			int index = ((int)numeric) - 48;
			numericCounter[index]++;
		}
		
		int[] alphabetCounter = new int[52];
		
		for (byte alphabet : upperAlphabets) { 
			int index = (((int)alphabet) - 66) * 2 + 2;
			alphabetCounter[index]++;
		}
		
		for (byte alphabet : lowerAlphabets) { 
			int index = (((int)alphabet) - 97) * 2 + 1;
			alphabetCounter[index]++;
		}
		
		SortedCharacterIterator iter = new SortedCharacterIterator(numericCounter, alphabetCounter);
		StringBuilder sb = new StringBuilder();
		iter.forEachRemaining(sb::append);
		
		return sb.toString();
	}
}
