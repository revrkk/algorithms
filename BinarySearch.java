public class BinarySearch{
	public static void main(String... arguments){
		if(arguments ==null || arguments.length < 1){
			System.err.println("Please enter the number to search");
		}
		int s = Integer.parseInt(arguments[0]);
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int length = arr.length;
		int mid = length / 2;

		while(arr[mid]!=s){

			if(mid==0 || mid==length-1){
				System.out.println("Not Exists");
				break;
			}

			if(arr[mid] > s){
				mid /= 2;
			} else if(arr[mid] < s) {
				mid += ((length - mid ) / 2);
			}

			if(arr[mid] == s){
				System.out.println("Found at" + mid);
				break;
			}
		}
	}

	private index binarySearch(int[] arr, int e){
		int mid;
		int l = 0;
		int r = arr.length - 1;
		while(l<r){
			if(arr[mid]==e){
				return mid;
			}else if(arr[mid] < e){
				r = mid + 1;
			}else {
				l = mid - 1;
			}
		}
	}
}