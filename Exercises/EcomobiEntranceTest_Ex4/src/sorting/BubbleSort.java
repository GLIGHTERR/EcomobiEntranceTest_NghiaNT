package sorting;

public class BubbleSort {
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int[] bubbleSort(int[] arr) {
		int size = arr.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
		
		return arr;
	}

	static int[] createArray(int[] arr, int low, int high) {
		int[] arrClone = new int[high - low + 1];

		for (int i = 0; i < arrClone.length; i++) {
			arrClone[i] = arr[low];
			low++;
		}

		return arrClone;
	}
	
	static int[] replaceArray(int[] arr, int[] subArr, int startIndex) {
		for (int i = 0; i < subArr.length; i++) {
			arr[startIndex] = subArr[i];
			startIndex++;
		}
		
		return arr;
	}
	
	static int partition(int[] arr, int low, int high) {		
		int pivot = arr[high]; 
		int i = low;
		
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		
		swap(arr, i, high);
		return i;
	}

	static void quickBubbleSort(int[] list, int limitLength) {
		int pivotIndex = 0;

		if (list.length % 2 == 0) {
			pivotIndex = list.length / 2;
		} else {
			pivotIndex = (list.length / 2) - 1;
		}
		
		int pi = partition(list, 0, list.length - 1);

		int[] arrLeft = createArray(list, 0, pi - 1);
		int[] arrRight = createArray(list, pi, list.length - 1);

		if (pivotIndex <= limitLength) {
			arrLeft = bubbleSort(arrLeft);
			replaceArray(list, arrLeft, 0);
			arrRight = bubbleSort(arrRight);
			replaceArray(list, arrRight, pivotIndex);
		} else {
			quickBubbleSort(arrLeft, limitLength);
			quickBubbleSort(arrRight, limitLength);
		}

	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90, 100, 87, 44 };
		quickBubbleSort(arr, 3);
		printArray(arr);
	}

}
