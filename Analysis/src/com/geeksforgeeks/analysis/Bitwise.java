package com.geeksforgeeks.analysis;

public class Bitwise {
	static int[] arr = new int[256];
	static {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = (i & 1) + arr[i / 2];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for all the values greater than 0
		int a = 1;
		System.out.println((a >>> 1));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(checkKthBit(39, 5));
		System.out.println(countSetBitArray(111111));
		System.out.println(countSetBitArray(111111));
		System.out.println(checkPowerOfTwo(4));
		System.out.println(checkPowerOfTwoBrain(5));
		int[] arr1 = { 2, 2, 3, 3, 4, 4, 4 };
		printOddOccuring(arr1);
		arr1 = new int[] { 1, 2, 5, 4 };
		findOneMissingInNPlusOne(arr1);
//		System.out.println(~(3-1));
		arr1 = new int[] { 3, 4, 3, 4, 8, 4, 4, 32, 7, 7 };
		printTwoOddOccuring(arr1);
		printSubsetofString("abcdef");
//		int n = 18;
//		n = n & ~(n - 1);
//		System.out.println(n);
//		System.out.println(countSetBits1(4));
//		System.out.println(1 ^ 2 ^ 3 ^ 4 ^ 5);
//		System.out.println(isSparse(41));
//		System.out.println(countSetBitsUpToN(18));
	}
	
	public static int countSetBitsUpToN(int n) {
		int result = 0;
		int i = 0;
		while((1<<i)<=n) {
			System.out.println(i);
			for(int j = 0;j<=n;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
			i++;
		}
		return result;
	}
	
	public static boolean isSparse(int n) {
		int prev = 1 & n;
		int current;
		while (n != 0) {
			n = n >>> 1;
			current = 1 & n;
			if (prev == 1 && current == 1) {
				return false;
			}
			prev = current;

		}
		return true;
	}

	public static boolean checkKthBit(int n, int k) {
		int a = 1;
		a = a << (k - 1);
		if ((n & a) > 0) {
			return true;
		}
		return false;
	}

	public static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n = n >>> 1;
		}
		return count;
	}
//	n = 15 (1111)
//	n = 14 (1110)
// 	n & n-1 will remove last set bit (1110) 
// 	n = 13 (1101)
// n and n-1 will give (1100)

	public static int countSetBitsBrainKerningam(int n) {
		int result = 0;
		while (n != 0) {
			n = (n & (n - 1));
			result++;

		}
		return result;
	}

// |<----8---->|<----8---->|<----8---->|<----8---->|

	public static int countSetBitArray(int n) {
		int result = 0;
//		generic for 32 bit and 64 bit
		while (n != 0) {
			result = result + arr[n & 0xff];
			n = n >>> 8;
		}
		return result;
	}

	public static boolean checkPowerOfTwo(int n) {
		boolean result = false;
		if (n == 0) {
			return true;
		}
		int count = 0;
		while (n != 0) {
			count = count + arr[n & 0xff];
			n = n >> 8;
		}
		if (count == 1)
			result = true;
		return result;
	}

	public static boolean checkPowerOfTwoBrain(int n) {
		if (n == 0)
			return true;
		return (n & (n - 1)) == 0;
	}

//	xor properties
//	0^x = x
//	a^b = b^a;
//	a^(b^c) = (a^b)^c
//	x ^ x = 0;
//	4 ^ 3 ^ 4 = 3;
//	one one number appears for odd number of times 
//	HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
//	for(int i = 0;i<arr.length;i++) {
//		if(m.get(arr[i])!=null) {
//			m.put(arr[i], m.get(arr[i])+1);
//		}else {
//			m.put(arr[i], 1);
//		}
//	}
//	for(Integer s: m.keySet()) {
//		if(m.get(s)%2!=0) {
//			System.out.println(s);
//		}
//	}
	public static void printOddOccuring(int[] arr) {
		int a = arr[0];
		for (int i = 1; i < arr.length; i++) {
			a = a ^ arr[i];
		}
		System.out.println(a);
	}

	public static void findOneMissingInNPlusOne(int[] arr) {
		int result1 = 0;
		for (int i = 1; i <= arr.length + 1; i++) {
			result1 = result1 ^ i;
		}
		int result2 = 0;
		for (int i = 0; i < arr.length; i++) {
			result2 = result2 ^ arr[i];
		}
		System.out.println(result1 ^ result2);
	}

	public static void printTwoOddOccuring(int[] arr) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}
		int lstSetBit = xor & ~(xor - 1);
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((lstSetBit & arr[i]) == 0) {
				result1 = result1 ^ arr[i];
			} else {
				result2 = result2 ^ arr[i];
			}
		}
		System.out.println(result2 + ", " + result1);
	}

	public static void printSubsetofString(String s) {
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < Math.pow(2, s.length()); i++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			int iterator = i;
			while (iterator != 0) {
				if ((iterator & 1) == 1) {
					sb.append(s.charAt(count));
				}
				iterator = iterator >> 1;
				count++;
			}
			sb1.append(sb.toString() + " ");
		}
		System.out.println(sb1.toString());
	}

	public static int countSetBits1(int n) {
		int[] arr = new int[256];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = (i & 1) + arr[i / 2];
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int iterator = i;
			while (iterator != 0) {
				result = result + arr[iterator & 0xff];
				iterator = iterator >> 8;
			}
		}
		return result;
	}
}
