package findLeastCommonMultiple;

import java.util.Scanner;

public class LeastCommonMultiple {
	final static Scanner SCANNER = new Scanner(System.in); // allow user to input from keyboard

	/**
	 * Check if input is number or not
	 */
	static int checkNumber(String s) {
		int num = -1;

		try {
			num = Integer.parseInt(s);
		} catch (NumberFormatException ex) {
			System.err.println("Must be number!");
			return -1;
		}

		return num;
	}

	/**
	 * Create an array in range [a, b]
	 */
	static int[] createArray(int a, int b) {
		int[] arr = new int[b - a + 1];
		int count = 0;

		for (int i = a; i <= b; i++) {
			arr[count] = i;
			++count;
		}

		return arr;
	}

	/**
	 * Main function that handles finding the least common multiple (lcm) number in
	 * a given array
	 */
	static int smallestCommons(int[] arr) {
		// lcm always the biggest number in the range, so set it to the last element
		// would decrease the time to check
		int lcm = arr[arr.length - 1];

		while (true) {
			boolean checkDivided = true;

			// check if all elements in array can be divisible by lcm, if not, the check
			// variable would turn false and go to the next loop
			for (int i = 0; i < arr.length; i++) {
				if (lcm % arr[i] != 0) {
					checkDivided = false;
					++lcm;
					break;
				}
			}

			if (checkDivided == true) {
				return lcm;
			}
		}
	}

	public static void main(String[] args) {
		int a = -1;
		int b = -1;
		String aString = "";
		String bString = "";
		int[] arr = null;

		while (true) {
			System.out.print("Input a: ");
			aString = SCANNER.next();
			System.out.print("Input b: ");
			bString = SCANNER.next();

			a = checkNumber(aString);
			b = checkNumber(bString);

			if (a <= 0 && b <= 0) {
				System.err.println("a & b must be positive numbers!");
				continue;
			} else {

				if (a <= b) {
					arr = createArray(a, b);
				} else {
					arr = createArray(b, a);
				}

				System.out.println(smallestCommons(arr));
				break;
			}
		}

		if (SCANNER != null) {
			SCANNER.close();
		}
	}

}
