package sumFibonacci;

import java.util.Scanner;

public class SumOddFibonacci {

	/**
	 * Function that return value of the nth number in Fibonacci array
	 */
	private static long fibo(long n) {
		if (n < 2) {
			return n;
		}

		return fibo(n - 2) + fibo(n - 1);
	}

	/**
	 * Main function that handles the sum of all odd Fibonacci number which is smaller than n
	 */
	private static long sumFibs(long n) {
		long sumFibos = 0;
		int i = 0;

		while (sumFibos + fibo(i) <= n) {

			if (fibo(i) % 2 != 0) {
				sumFibos += fibo(i);
			}
			
			i++;

		}
		
		return sumFibos;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // allow user to input from keyboard
		String nString = "";
		long n = -1;
		
		while (true) {
			System.out.print("Input n: ");
			nString = sc.next();
			
			try {
				n = Long.parseLong(nString);
			} catch (NumberFormatException ex) {
				System.err.println("Must input number!");
				continue;
			}
			
			if (n < 0) {
				System.err.println("Must input positive number!");
				continue;
			} else {
				System.out.println(sumFibs(n));
				break;
			}
		}
		
		if (sc != null) {
			sc.close();
		}
	}

}
