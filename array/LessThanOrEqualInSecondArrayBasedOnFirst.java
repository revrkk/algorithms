package array;

import java.util.Arrays;

public class LessThanOrEqualInSecondArrayBasedOnFirst {

	public static void main(String[] args) {
		int[] array1 = {4, 5, 1, 2, 3, 6}; // [1, 2, 3, 4, 5, 6]
		int[] array2 = {5, 1, 6, 1, 2, 2, 5, 7}; // [1, 1, 2, 2, 5, 5, 6, 7]
		
		int[] result = new int[array1.length];
		
		// APPROACH 1: This will be obviously O(nm)
		/*
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array2.length; j++) {
				if(array2[j] <= array1[i]) {
					result[i]++;
				}
			}
		}
		*/
		//APPROACH 2: 
		Arrays.sort(array2);
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array2.length; j++) {
				if(array2[j] > array1[i]) {
					result[i] = j - 1;
				}
			}
		}
		
		System.out.println(Arrays.toString(result));
	}
}
