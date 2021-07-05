package com.geeksforgeeks.sorting;

public class Sorting {

	public static void main(String[] args) {
		int arr[] = { 14, 33, 27, 10, 35, 19, 42, 44 };
//		bubbleSort(arr);
//		selectionSort(arr);
//		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		insertionSort(arr);
		disp_arr(arr);

	}

	// 90 80 90 20 stable sorting
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (i - 1 >= 0 && arr[i - 1] > arr[i]) { // for sorted array to take o(n) time
				for (int j = 0; j <= i; j++) {
					if (arr[i] < arr[j]) {
						swap(arr, i, j);
					}
				}
			}
		}
	}

	/*
	 * not stable
	 */
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean isSorted = false;
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
					isSorted = true;
				}
			}
			if (i != min)
				swap(arr, i, min);
			if (!isSorted)
				break;
		}
	}

	/*
	 * stable
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean sorted = false;
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
					sorted = true;
				}
			}
			if (sorted == false)
				break;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		if (i >= arr.length || j >= arr.length)
			return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void disp_arr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
