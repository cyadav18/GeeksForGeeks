package com.geeksforgeeks.arrays;

public class ProblemsGeeks {

	public static void main(String[] args) {
		int[] L = { 1,5,9,13,21 };
		int[] R = { 15, 8, 12, 20, 30 };
		int[] arr = maxOccured(L, R);
		displayArray(arr);
	}

//	Given n integer ranges, the task is to find the maximum occurring integer in these ranges. If more than one such integer exits, find the smallest one. The ranges are given as two arrays L[] and R[].  L[i] consists of starting point of range and R[i] consists of corresponding end point of the range.
//
//	For example consider the following ranges.
//	L[] = {2, 1, 3}, R[] = {5, 3, 9)
//	Ranges represented by above arrays are.
//	[2, 5] = {2, 3, 4, 5}
//	[1, 3] = {1, 2, 3}
//	[3, 9] = {3, 4, 5, 6, 7, 8, 9}
//	The maximum occurred integer in these ranges is 3.

	// int[] L = { 1, 4, 9, 13, 21 };
//	int[] R = { 15, 8, 12, 20, 30 };
	public static int[] maxOccured(int L[], int R[]) {
		int[] finalRange = new int[2];
		int[] range = new int[2];
		range[0] = L[0];
		range[1] = R[0];
		finalRange[0] = range[0];
		finalRange[1] = range[1];
		for (int i = 1; i < L.length; i++) {
			int leftMax = L[i];
			int rightMin = R[i];
			if (leftMax > range[0]) {
				range[0] = leftMax;
			}
			if (rightMin < range[1]) {
				range[1] = rightMin;
			}

			if (range[1] >= range[0]) {
				finalRange[0] = range[0];
				finalRange[1] = range[1];
			} else {
				range[0] = finalRange[0];
				range[1] = finalRange[1];
			}
		}
		return finalRange;
	}

	public static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
