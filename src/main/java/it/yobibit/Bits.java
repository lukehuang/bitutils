package it.yobibit;


public class Bits {

	public enum BitListSize {
		
		Size1(1),
		Size2(2),
		Size4(4);
		
		int size;
		int max;
		
		BitListSize(int size) {
			this.size = size;
			this.max = ((int) Math.pow(2, size)) - 1;
		}
		
		public int get() {
			return size;
		}
		
		public int max() {
			return max;
		}
	}
	
	public static boolean inRange(int value, BitListSize size) {
		return value >= 0 && value <= size.max;
	}	

	public static BitListSize getMinSize(int maxValue) {
		if (Bits.inRange(maxValue, BitListSize.Size1)) {
			return BitListSize.Size1;
		} else if (Bits.inRange(maxValue, BitListSize.Size2)) {
			return BitListSize.Size2;				
		} else if (Bits.inRange(maxValue, BitListSize.Size4)) {
			return BitListSize.Size4;
		} else {
			return null;
		}
	}
	
	public static int get(int bits, int pos) {
		return bits & (1 << pos);
	}	
	
	public static int set(int bits, int pos) {
		return bits | (1 << pos);
	}
	
	public static String asString(int bits) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			if (get(bits, i) != 0) result.append("1");
			else result.append("0");
		}
		return result.toString();
	}
}