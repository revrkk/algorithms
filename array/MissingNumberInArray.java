package array;

/**
 * To find missing number in an array which may have duplicate values and or not
 * sorted
 * 
 * @author revanth_v
 *
 */
public class MissingNumberInArray {

	public static void main(String[] args) {
		//approachOne(new int[] { 100, 3, 1, 1, 2});
		approachTwo(new int[] { 100, 3, 1, 1, 2 }, 100);
	}

	private static void approachTwo(int[] numbers, int max) {
		boolean[] bs = new boolean[max];
		for (int n : numbers) {
			bs[n - 1] = true;
		}
		for (int k = 0; k < bs.length; k++) {
			if(!bs[k]) {
				System.out.println(k+1);
			}
		}
	}

	private static void approachOne(int[] numbers) {

		// Sort Array and Set -1 for repeated characters
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				} else if (numbers[i] == numbers[j]) {
					numbers[i] = -1;
				}
			}
		}

		// Find & Print missing character
		int i = 1;
		for (int n : numbers) {
			if (n != -1) {
				while (n != i) {
					System.out.println(i++);
				}
				if (n == i) {
					i++;
				}
			}
		}
	}

}
