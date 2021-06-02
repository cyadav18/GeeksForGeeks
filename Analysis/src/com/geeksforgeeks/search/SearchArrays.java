package com.geeksforgeeks.search;

import com.geeksforgeeks.arrays.Arrays;

public class SearchArrays {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 20, 30, 30 };
		Arrays.displayArray(arr);
		System.out.println("binarySearchWrapper " + binarySearchWrapper(arr, 21));
	}

	public static int binarySearchWrapper(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		return binarySearchSortedRecursion(arr, element, low, high);

	}

	public static int binarySearchSortedRecursion(int[] arr, int element, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[mid] > element) {
				return binarySearchSortedRecursion(arr, element, low, mid - 1);
			} else {
				return binarySearchSortedRecursion(arr, element, mid + 1, high);
			}
		}
	}
	/*
	 * Searching a element in a array which is sorted
	 */

	public static int binarySearchSortedArray(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		if (low == high)
			return low;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				return mid;
			}
			if (arr[mid] > element) {
				high = mid - 1;
			}
			if (arr[mid] < element) {
				low = mid + 1;
			}
		}
		return -1;
	}

}
