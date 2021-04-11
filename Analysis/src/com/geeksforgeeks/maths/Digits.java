package com.geeksforgeeks.maths;

public class Digits {

	public static void main(String[] args) {
		int n = 234;
		System.out.println(countDigits(n));
		System.out.println(reverseDigits(n));
		System.out.println(checkPalindromeDigits(n));
		System.out.println(factorial(11));
		System.out.println(countTrailingZeroes(30));
		System.out.println(hcf(24, 36));
		System.out.println(checkPrime(229));
		printPrimeFactors(450);
		System.out.println();
		printAllDivisors(100);
		System.out.println();
		sieveofEratosthenes(29);
	}

	public static int countDigits(int n) {
		int count = 0;
		while (n != 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

	public static int reverseDigits(int n) {
		int result = 0;
		while (n != 0) {
			int rem = n % 10;
			n = n / 10;
			result = result * 10 + rem;
		}
		return result;
	}

	public static boolean checkPalindromeDigits(int n) {
		return (n == reverseDigits(n));
	}

	public static int factorial(int n) {
		if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static int countTrailingZeroes(int n) {
		int count = 0;
		while (n >= 5) {
			count = count + (n / 5);
			n = n / 5;
		}
		return count;
	}

	public static int hcf(int a, int b) {
		if (b == 1)
			return a;
		else {
			int rem = a % b;
			if (b % rem == 0)
				return rem;
			else if (b > rem)
				return hcf(b, rem);
			else
				return hcf(rem, b);
		}
	}

	public static int lcm(int a, int b) {
		return (a * b) / (hcf(a, b));
	}

//5 7 11 13 17 19 23 25 29 31 35 37 41 43 47 49 53 55 59 61 65 67 71 73 77 79 83 85 89 91 95 97
	public static boolean checkPrime(int n) {
		if (n <= 0)
			return false;
		if (n % 2 == 0)
			return false;
		if (n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i = i + 6) {
			if (n % i == 0)
				return false;
			if (n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static void printPrimeFactors(int n) {
		if (n <= 1)
			return;
		if (checkPrime(n))
			return;
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n = n / 2;
		}
		while (n % 3 == 0) {
			System.out.print(3 + " ");
			n = n / 3;
		}
		for (int i = 5; i * i <= n; i = i + 6) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
			while (n % (i + 2) == 0) {
				System.out.print((i + 2) + " ");
				n = n / (i + 2);
			}
		}
	}

	public static void printAllDivisors(int n) {
		int i;
		for (i = 1; i * i <= n; i++) {
			if (n % i == 0)
				System.out.print(i + " ");
		}
		for (; i > 0; i--) {
			if (n % i == 0)
				System.out.print((n / i) + " ");
		}
	}

	public static void sieveofEratosthenes(int n) {
		boolean[] arr = new boolean[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = true;
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i]) {
				System.out.print(i+" ");
				for (int j = 2 * i; j < arr.length; j = j + i) {
					arr[j] = false;
				}
			}
		}
		System.out.println();
	}
}
