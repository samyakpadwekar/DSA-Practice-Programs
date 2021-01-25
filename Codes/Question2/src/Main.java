import java.util.Arrays;

public class Main {
	public static int selectionSort(double []arr) {
		int swap=0;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					double temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					swap++;
				}
			}
		}
		return swap;
	}
	
	public static void main(String[] args) {
		double[] arr = {6.3, 4.5, 2.6, 8.4, 3.9, 1.7};
		System.out.println("Selection Sort");
		System.out.println("Before: " + Arrays.toString(arr));
		int swap=selectionSort(arr);
		System.out.println("After : " + Arrays.toString(arr));
		System.out.println("Number of swapping : " + swap);
	}

}