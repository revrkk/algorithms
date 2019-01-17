package array;

public class LargestOrSmallest {

	public static void main(String[] args) {
		int[] in = { 1000, 1, 4, 7, 8, 123, 45, 0, -12 };
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int n : in) {
			if(n < min) {
				min = n;
			}
			if(n > max) {
				max = n;
			}
		}
		
		System.out.printf("Min: %d, Max: %d", min, max);
	}

}
