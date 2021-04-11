package com.geeksforgeeks.recursion;

public class Recursion {
	public static void main(String[] args) {
		System.out.println("Recursion");
		printReverse(235);
		System.out.println();
		System.out.println(sumOfDigits(234));
		printNtoOne(12);
		System.out.println();
		printOneToN(12);
		System.out.println();
		printOneToNTail(12);
		System.out.println();
		System.out.println(factorialTail(5));
		System.out.println(factorial(5));
		System.out.println(fibonacciNth(4));
		System.out.println(sumOfNaturalNumbers(4));
		System.out.println(reverseString("abcd", 0));
		String s = "abqwba";
		System.out.println(checkPalindrome(s, 0, s.length() - 1));
		System.out.println(maxRopeCut(23, 11, 9, 12));
		System.out.println(maxRopeCut(5, 2, 5, 1));
		System.out.println(maxRopeCut(9, 2, 2, 2));
		generateSubset("ABC","",0);
	}

	public static void printReverse(int n) {
		if (n == 0)
			return;
		else {
			int rem = n % 10;
			System.out.print(rem);
			printReverse(n / 10);
		}
	}

	public static int sumOfDigits(int n) {
		if (n <= 9) {
			return n;
		} else {
			int rem = n % 10;
			int sum = rem + sumOfDigits(n / 10);
			return sum;
		}
	}

	public static void printNtoOne(int n) {
		if (n < 1)
			return;
		else {
			System.out.print(n + " ");
			printNtoOne(n - 1);
		}
	}

	public static void printOneToN(int n) {
		if (n < 1)
			return;
		else {
			printOneToN(n - 1);
			System.out.print(n + " ");
		}
	}

	static int var = 0;

	public static void printOneToNTail(int n) {
		if (n - var <= 0)
			return;
		else {
			var++;
			System.out.print(var + " ");
			printOneToNTail(n);

		}
	}

	static int mul = 1;

	public static int factorialTail(int n) {
		if (n < 1)
			return mul;
		else {
			mul = mul * n;
			return factorialTail(n - 1);

		}
	}

	public static int factorial(int n) {
		if (n < 1)
			return 1;
		else {
			return n * factorial(n - 1);
		}
	}

	public static int fibonacciNth(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		else {
			return fibonacciNth(n - 1) + fibonacciNth(n - 2);
		}
	}

	public static int sumOfNaturalNumbers(int n) {
		if (n <= 1)
			return n;
		else
			return n + sumOfNaturalNumbers(n - 1);
	}

	public static String reverseString(String s, int i) {
		if (i >= s.length())
			return "";
		else {
			String str = s.charAt(i) + "";
			String rtr = reverseString(s, ++i);
			return rtr + str;
		}
	}

	public static boolean checkPalindrome(String s, int start, int end) {
		if (start >= end)
			return true;
		else {
			String begin = s.charAt(start) + "";
			String last = s.charAt(end) + "";
			boolean b = begin.equals(last);
			return b & checkPalindrome(s, ++start, --end);
		}
	}

	public static int maxRopeCut(int n, int a, int b, int c) {
		if (n == 0) {
			return 0;
		}
		if (n < 0)
			return -1;
		else {
			int r1 = maxRopeCut(n - a, a, b, c);
			int r2 = maxRopeCut(n - b, a, b, c);
			int r3 = maxRopeCut(n - c, a, b, c);
			int result = -1;
			if (r1 > r2) {
				if (r1 > r3) {
					result = r1;
				} else {
					result = r3;
				}
			} else {
				if (r2 > r3) {
					result = r2;
				} else {
					result = r3;
				}
			}
			if (result == -1)
				return -1;
			else
				return 1 + result;
		}
	}
	
	public static void generateSubset(String s,String current, int index){
		if(index == s.length()) {
			System.out.print(current+" ");
			return;
		}else {
			generateSubset(s,current,index+1);
			generateSubset(s,current+s.charAt(index),index+1);
		}
		
	}
}