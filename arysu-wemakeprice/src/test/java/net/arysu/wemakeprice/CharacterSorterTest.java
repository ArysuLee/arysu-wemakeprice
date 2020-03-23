package net.arysu.wemakeprice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharacterSorterTest {
	
	private CharacterSorter sorter;
	
	@BeforeEach
	void init() {
		sorter = new CharacterSorter();
	}

	@Test
	void testSort() {
		
		byte[] numerics = new byte[] {52, 53, 49, 50, 49, 49, 49, 53, 48};
		byte[] lowerAlphabet = new byte[] {112, 97, 99, 104, 101, 116, 116, 112, 108, 105, 101, 110, 116, 116, 97, 114, 103, 101, 116};
		byte[] upperAlphabet = new byte[] {65, 72, 67, 65, 80, 73, 80, 80, 80, 80, 80, 80, 79, 80, 80, 85, 82, 76, 80, 80, 85, 82, 76};
		
		ByteHolder holder = new ByteHolder();
		for (byte b : numerics) {
			holder.writeNumeric(b);
		}
		for (byte b : lowerAlphabet) {
			holder.writeLowerAlphabet(b);
		}
		for (byte b : upperAlphabet) {
			holder.writeUpperAlphabet(b);
		}
		
		String string = sorter.sort(holder);
		
		assertEquals("a0a1B1B1c1D2F4F5F5HhIiJllMOopppppppppppQQrrSUUUUUuu", string);
	}

}
