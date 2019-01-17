package array;

public class DuplicateNumbersInArray {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 3, 4, 6, 6, 7, 7, 8, 9, 0, 0 };
		int[] occurence = new int[input.length];
		
		for (int i = 0; i < input.length; i++)
			occurence[input[i]]++;

		for (int i = 0; i < input.length; i++)
			if (occurence[i] > 1)
				System.out.println(i);
	}
}
