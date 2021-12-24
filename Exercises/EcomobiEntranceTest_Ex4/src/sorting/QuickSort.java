package sorting;

import java.util.Scanner;

public class QuickSort {
	final static Scanner SCANNER = new Scanner(System.in); // allow user to input from keyboard

	/**
	 * Function to swap 2 elements a and b in array arr
	 */
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * Function to take last element in specific range as pivot Then place pivot in
	 * the right position in sorted array Sorted array: all smaller than pivot to
	 * the left of it and all greater to the right of pivot
	 */
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // set pivot as last element of array
		int i = low; // beginning point

		// arrange all smaller pivot to the very left
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}

		// when all smaller went left, swap pivot with the next index of the last small
		// number -> pivot goes to right place
		swap(arr, i, high);
		return i;
	}

	/**
	 * Main function that handle QuickSort process
	 * 
	 * @param arr:  array to be sorted
	 * @param low:  starting index
	 * @param high: ending index
	 */
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high); // set & get right place for pivot
			quickSort(arr, low, partitionIndex - 1); // sort on the left of current pivot
			quickSort(arr, partitionIndex + 1, high); // sort on the right of current pivot
		}
	}

	/**
	 * Function to check if input is number or not
	 * 
	 * @param mess: message to send to user know what they are doing
	 * @return the number after validated
	 */
	static int checkNumber(String mess) {
		int num;

		while (true) {
			System.out.print(mess);
			String numString = SCANNER.next();

			try {
				num = Integer.parseInt(numString);
			} catch (NumberFormatException ex) {
				System.err.println("Must be number!");
				continue;
			}

			return num;
		}

	}

	/**
	 * Create an array base on the inputed size
	 */
	static int[] createArray(int size) {
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = checkNumber("arr[" + i + "]: ");
		}

		return arr;
	}

	/**
	 * Print out the array
	 */
	static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	public static void main1(String[] args) {
		int[] arr = null;

		while (true) {
			int arrLength = checkNumber("Input size of the array: ");

			if (arrLength < 0) {
				System.err.println("Size of array must be a positive integer!");
				continue;
			} else {
				arr = createArray(arrLength);
				System.out.println("Unsorted array: ");
				printArray(arr, arrLength);

				System.out.println("Sorted array: ");
				quickSort(arr, 0, arrLength - 1);
				printArray(arr, arrLength);

				break;
			}
		}

		if (SCANNER != null) {
			SCANNER.close();
		}

	}

}
