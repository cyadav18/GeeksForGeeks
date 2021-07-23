package com.geeksforgeeks.bitwise;

public class Bitwise {

	static int[] bitArray = new int[256];
	static {
		bitArray[0] = 0;
		bitArray[1] = 1;
		for (int i = 2; i < bitArray.length; i++) {
			bitArray[i] = bitArray[i / 2] + (i & 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println(checkKthBit(12, 3));
		System.out.println(countSetBitMethod1(12));
		System.out.println(countSetBitMethod2(12));
		System.out.println(countSetBitMethod3(12));
		System.out.println(checkPowerOfTwoMethod1(18));
		System.out.println(checkPowerOfTwoMethod2(126));
		int[] arr = { 1, 2, 3, 4, 2, 3, 1, 4 };
		System.out.println(returnOddOccuringNumber(arr));
		System.out.println(MostSignificantBit(12));
		System.out.println(MostSignificantBitMethod2(12));
		System.out.println(leastSignificantBit(12));
		arr = new int[] { 1, 1, 2, 2, 3, 4, 5, 4, 6, 6 };
		findTwoOddOccuringNumbers(arr);
		String s = "abcd";
		subsetOfString(s);
		System.out.println(countTotalSetBitUpTo(17));
		arr = new int[] { 1, 2, 6, 4, 5, 6 };
//		arr = new int[] { 1, 2, 3, 3 };
		printTwoElements(arr);
	}

	public static boolean checkKthBit(int n, int k) {
		int m = 1 << (k - 1);
		return (n & m) > 0;
	}

	public static int countSetBitMethod1(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n = n >>> 1;
		}
		return count;
	}

	public static int countSetBitMethod2(int n) {
		int count = 0;
		while (n != 0) {
			n = n & n - 1;
			count++;
		}
		return count;
	}

	public static int countSetBitMethod3(int n) {
		int count = 0;
		while (n != 0) {
			count = count + bitArray[n & 0xff];
			n = n >>> 8;
		}
		return count;
	}

	public static boolean checkPowerOfTwoMethod1(int n) {
		return countSetBitMethod3(n) == 1;
	}

	public static boolean checkPowerOfTwoMethod2(int n) {
		return (n & (n - 1)) == 0;
	}

	public static int returnOddOccuringNumber(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num = num ^ arr[i];
		}
		return num;
	}

	public static int MostSignificantBit(int n) {
		int result = (int) (Math.log(n) / Math.log(2));
		return 1 << result;
	}

	public static int MostSignificantBitMethod2(int n) {
		int prev = 0;
		int result = n;
		int count = 1;
		while (prev != result) {
			prev = result;
			result = result | (result >> count);
			count = count * 2;
		}
		return (result + 1) >> 1;
	}

	public static int leastSignificantBit(int n) {
		int result = n & ~(n - 1);
		return result;
	}

	public static void findTwoOddOccuringNumbers(int[] arr) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}
		int lsb = xor & ~(xor - 1);
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & lsb) > 0) {
				result1 = result1 ^ arr[i];
			} else {
				result2 = result2 ^ arr[i];
			}
		}
		System.out.println(result1 + " " + result2);
	}

	public static void subsetOfString(String s) {
		StringBuilder sb = new StringBuilder();
		int end = (int) Math.pow(2, s.length());
		for (int i = 0; i < end; i++) {
			StringBuilder sb1 = new StringBuilder();
			int iterator = i;
			int count = 0;
			while (iterator != 0) {
				if ((iterator & 1) == 1) {
					sb.append(s.charAt(count));
				}
				iterator = iterator >>> 1;
				count++;
			}
			sb.append(sb1.toString() + " ");
		}
		System.out.println(sb.toString());
	}

	public static int countTotalSetBitUpTo(int n) {
		int count = 0;
		int i = 0;
		while ((1 << i) <= n) {
			boolean flip = false;
			int change = 1 << i;
			for (int j = 0; j <= n; j++) {
				if (flip) {
					count++;
				}
				if (change == 1) {
					flip = !flip;
					change = 1 << i;
				} else {
					change--;
				}

			}
			i++;
		}
		return count;
	}

	/*
	 * Given an unsorted array of size n. Array elements are in the range from 1 to
	 * n. One number from set {1, 2, …n} is missing and one number occurs twice in
	 * the array. Find these two numbers.
	 */
	public static void printTwoElements(int[] arr) {
		int arr_sum = 0;
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor = (xor ^ arr[i]);
			arr_sum = arr_sum + arr[i];
		}
		for (int i = 1; i <= arr.length; i++) {
			xor = xor ^ i;
		}
		int setbit = xor & ~(xor - 1);
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((setbit & arr[i]) > 0) {
				result1 = (result1 ^ arr[i]);
			} else {
				result2 = (result2 ^ arr[i]);
			}
		}
		for (int i = 1; i <= arr.length; i++) {
			if ((setbit & i) > 0) {
				result1 = (result1 ^ i);
			} else {
				result2 = (result2 ^ i);
			}
		}
		int total_sum = arr.length * (arr.length + 1) / 2;
		int dif = total_sum - arr_sum;
		int missing = 0;
		int repeted = 0;
		if (dif < 0)
			dif = dif * -1;
		if (result1 == result2 + dif) {
			missing = result2;
			repeted = result1;
		} else if (result2 == result1 + dif) {
			missing = result1;
			repeted = result2;
		}
		missing = result1;
		repeted = result2;
		System.out.println(repeted + " " + missing);
	}
}
