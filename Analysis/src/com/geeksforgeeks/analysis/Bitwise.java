package com.geeksforgeeks.analysis;

public class Bitwise {
	static int[]arr = new int[256];
	static {
		for(int i = 1;i<arr.length;i++) {
			arr[i] = (i&1) + arr[i/2]; 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for all the values greater than 0
		int a = 1;
		System.out.println((a>>>1));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(checkKthBit(0, 4));
		System.out.println(countSetBits(111111));
		System.out.println(countSetBitArray(111111));
		System.out.println(checkPowerOfTwo(4));
		System.out.println(checkPowerOfTwoBrain(5));
		int[]arr1 = {2,2,3,3,4,4,4};
		printOddOccuring(arr1);
		System.out.println(1^5^3^4);
	}

	public static boolean checkKthBit(int n,int k) {
		if(n==0) {
			return false;
		}
		int a = 1;
		a = a<<(k-1);
		if((n&a)>0) {
			return true;
		}
		return false;
	}
	public static int countSetBits(int n) {
		int count = 0;
		while(n!=0) {
			if((n&1)==1)
				count++;
			n = n>>>1;
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
		while(n!=0) {
			n = (n &(n-1));
			result++;
			
		}
		return result;
	}
	
// |<----8---->|<----8---->|<----8---->|<----8---->|
	
	public static int countSetBitArray(int n) {
		int result = 0;
//		generic for 32 bit and 64 bit
		while(n!=0) {
			result = result+arr[n&0xff];
			n = n>>>8;
		}
		return result;
	}
	
	public static boolean checkPowerOfTwo(int n) {
		boolean result = false;
		if(n==0) {
			return true;
		}
		int count = 0;
		while(n!=0) {
			count = count+arr[n&0xff];
			n = n>>8;
		}
		if(count==1)
			result = true;
		return result;
	}
	
	public static boolean checkPowerOfTwoBrain(int n){
		if(n==0)
			return true;
		return (n&(n-1))==0;
	}
	
//	xor properties
//	0^x = x
//	a^b = b^a;
//	a^(b^c) = (a^b)^c
//	x ^ x = 0;
//	4 ^ 3 ^ 4 = 3;
//	one one number appears for odd number of times 
	public static void printOddOccuring(int[]arr) {
//		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
//		for(int i = 0;i<arr.length;i++) {
//			if(m.get(arr[i])!=null) {
//				m.put(arr[i], m.get(arr[i])+1);
//			}else {
//				m.put(arr[i], 1);
//			}
//		}
//		for(Integer s: m.keySet()) {
//			if(m.get(s)%2!=0) {
//				System.out.println(s);
//			}
//		}
		int a = arr[0];
		for(int i = 1;i<arr.length;i++) {
			a = a ^ arr[i];
		}
		System.out.println(a);
	}
}
