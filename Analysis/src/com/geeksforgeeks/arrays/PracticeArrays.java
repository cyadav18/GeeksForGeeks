package com.geeksforgeeks.arrays;

public class PracticeArrays {

	public static void main(String[] args) {
		int[] arr = { 46, 34, 67, 98, 74, 52, 72, 39, 70, 27, 78 };
		displayArray(arr);
		System.out.println(arr[findSecondMax(arr)]);
		System.out.println(arr[findThirdMax(arr)]);
		arr = new int[] { 10, 10, 10, 20, 20, 20, 30, 30, 30 };
		removeDuplicatesFromSorted(arr);
		displayArray(arr);
		arr = new int[] { 10, 20, 0, 0, 0, 0, 0, 0, 0, 30, 40, 0, 0, 0, 0, 0, 0, 50 };
		moveZeroesToEndSecond(arr);
		displayArray(arr);

	}

	public static void moveZeroesToEndSecond(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			} else {
				int temp = arr[i];
				arr[i] = arr[i - count];
				arr[i - count] = temp;
			}
		}
	}

	public static void removeDuplicatesFromSorted(int[] arr) {
		if (arr.length < 2) {
			return;
		}
		int prev = arr[0];
		int size = 0;
		for (int i = 1; i < arr.length; i++) {
			if (prev == arr[i]) {
				size++;
			} else {
				arr[i - size] = arr[i];
			}
			prev = arr[i];
		}
	}

	public static int findThirdMax(int[] arr) {
		if (arr.length < 3) {
			return -1;
		}
		int max1 = arr[0];
		int max2 = Integer.MIN_VALUE;
		int index1 = 0;
		int index2 = -1;
		int index3 = -1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
				index3 = index2;
				index2 = index1;
				index1 = i;
			} else if (arr[i] != max1 && arr[i] > max2) {
				max2 = arr[i];
				index3 = index2;
				index2 = i;
			} else if (arr[i] != max1 && arr[i] != max2) {
				index3 = arr[i];
			}
		}
		return index3;
	}

	public static int findSecondMax(int[] arr) {
		int max1 = arr[0];
		int max2 = Integer.MIN_VALUE;
		int index2 = -1;
		int index1 = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
				index2 = index1;
				index1 = i;
			} else if (arr[i] != max1 && arr[i] > max2) {
				max2 = arr[i];
				index2 = i;
			}
		}
		return index2;
	}

	public static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
