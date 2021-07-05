package com.geeksforgeeks.recursion;

public class Practice {

	static int palindromeCount = 0;

	public static void main(String[] args) {
		System.out.println("Practicing");
		for (int i = 1; i <= 10; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		System.out.println();
		System.out.println(sumOfNaturalNumbersUpToN(55));
		System.out.println(checkPalindromeString("aba"));
		System.out.println(countSumOfDigits(123));
		System.out.println(maxCutRope(3, 1, 2, 2));
		printSubString("ABC", "", 0);
		System.out.println("\nDone");
		int[] arr = { 5, 15, 10, 10, 15 };
		System.out.println(subStringSum(arr, 25, 0));
		printPermutation("ABCDE", 0);
	}

	public static void printPermutation(String string, int i) {
		if (i == string.length() - 1) {
			System.out.print(string + " ");
			return;
		} else {
			for (int j = i; j < string.length(); j++) {
				string = swap(string, i, j);
				printPermutation(string, i + 1);
				string = swap(string, i, j);
			}
		}
	}

	public static String swap(String string, int i, int j) {
		StringBuilder sb = new StringBuilder(string);
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb.toString();
	}

	public static int subStringSum(int[] arr, int sum, int i) {
		if (sum == 0)
			return 1;
		else if (i > arr.length - 1 || sum < 0)
			return 0;
		else {
			int left = subStringSum(arr, sum, i + 1);
			int right = subStringSum(arr, sum - arr[i], i + 1);
			return left + right;
		}
	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static int sumOfNaturalNumbersUpToN(int n) {
		if (n == 1 || n == 0)
			return n;
		else
			return n + sumOfNaturalNumbersUpToN(n - 1);
	}

	public static boolean checkPalindrome(String s) {
		palindromeCount = 0;
		return checkPalindromeString(s);
	}

	private static boolean checkPalindromeString(String s) {
		if (s.length() <= 1) {
			return true;
		}
		if (palindromeCount >= s.length() / 2) {
			return true;
		}
		char first = s.charAt(palindromeCount);
		char last = s.charAt(s.length() - palindromeCount - 1);
		palindromeCount++;
		return (first == last) && checkPalindromeString(s);
	}

	public static int countSumOfDigits(int n) {
		if (n < 10) {
			return n;
		} else {
			return (n % 10) + countSumOfDigits(n / 10);
		}
	}

	public static int maxCutRope(int n, int a, int b, int c) {
		if (n == 0)
			return 0;
		if (n < 0)
			return -1;
		int first = maxCutRope(n - a, a, b, c);
		int second = maxCutRope(n - b, a, b, c);
		int third = maxCutRope(n - c, a, b, c);
		int max = Math.max(Math.max(first, second), third);
		if (max >= 0)
			return 1 + max;
		else
			return max;

	}

	public static void printSubString(String string, String current, int index) {
		if (string.length() == index) {
			System.out.print(current + " ");
			return;
		} else {
			printSubString(string, current, index + 1);
			printSubString(string, current + string.charAt(index), index + 1);
		}
	}

}
