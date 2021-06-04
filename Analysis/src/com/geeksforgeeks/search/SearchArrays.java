package com.geeksforgeeks.search;

import com.geeksforgeeks.arrays.Arrays;

public class SearchArrays {

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 15, 21, 23, 23, 23, 34, 45, 56, 67, 78, 89, 90 };
		Arrays.displayArray(arr);
		System.out.println("binarySearchWrapper " + binarySearchWrapper(arr, 23));
		System.out.println("binarySearchSortedArray " + binarySearchSortedArray(arr, 23));
		arr = new int[] { 12, 15, 21, 23, 23, 23, 34, 45, 56, 67, 78, 89, 90 };
		System.out.println("searchFirstOccurrence " + searchFirstOccurrence(arr, 23));
		System.out.println("searchFirstOccurrenceIterative " + searchFirstOccurrenceIterative(arr, 23));
		System.out.println("searchLastOccurrence " + searchLastOccurrence(arr, 23));
		System.out.println("searchLastOccurrenceIterative " + searchLastOccurrenceIterative(arr, 23));
		System.out.println("countOccurrence " + countOccurrence(arr, 21));
	}

//Not efficient 
	public static int countOccurrence(int[] arr, int element) {
		return countTheOccurrenceInSortedArray(arr, element, 0, arr.length - 1);
	}

	public static int countTheOccurrenceInSortedArray(int[] arr, int element, int low, int high) {
		if (low > high)
			return 0;
		else {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if (low == high)
					return 1;
				int left = 0;
				if (mid - 1 >= 0)
					left = countTheOccurrenceInSortedArray(arr, element, low, mid - 1);
				int right = 0;
				if (mid + 1 < arr.length)
					right = countTheOccurrenceInSortedArray(arr, element, mid + 1, high);
				return left + right + 1;
			} else {
				if (arr[mid] > element) {
					return countTheOccurrenceInSortedArray(arr, element, low, mid - 1);
				} else {
					return countTheOccurrenceInSortedArray(arr, element, mid + 1, high);
				}
			}
		}
	}

	// Search the last occurrence of the element in sorted array
	public static int searchLastOccurrenceIterative(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if ((mid + 1) < arr.length && arr[mid + 1] == arr[mid]) {
					low = mid + 1;
				} else {
					return mid;
				}
			} else if (arr[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static int searchLastOccurrence(int[] arr, int element) {
		return LastOccurenceSortedRecursion(arr, element, 0, arr.length - 1);
	}

	public static int LastOccurenceSortedRecursion(int[] arr, int element, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if ((mid + 1) < arr.length && arr[mid] == arr[mid + 1]) {
					return LastOccurenceSortedRecursion(arr, element, mid + 1, high);
				} else {
					return mid;
				}
			} else if (arr[mid] > element) {
				return LastOccurenceSortedRecursion(arr, element, low, mid - 1);
			} else {
				return LastOccurenceSortedRecursion(arr, element, mid + 1, high);
			}
		}
	}

	// Search the first occurrence of the element in sorted array
	public static int searchFirstOccurrenceIterative(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if ((mid - 1) >= 0 && arr[mid - 1] == arr[mid]) {
					high = mid - 1;
				} else {
					return mid;
				}
			} else if (arr[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static int searchFirstOccurrence(int[] arr, int element) {
		return FirstOccurenceSortedRecursion(arr, element, 0, arr.length - 1);
	}

	public static int FirstOccurenceSortedRecursion(int[] arr, int element, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if ((mid - 1) >= 0 && (arr[mid] == arr[mid - 1])) {
					return FirstOccurenceSortedRecursion(arr, element, low, mid - 1);
				} else {
					return mid;
				}
			} else if (arr[mid] > element)
				return FirstOccurenceSortedRecursion(arr, element, low, mid - 1);
			else
				return FirstOccurenceSortedRecursion(arr, element, mid + 1, high);
		}
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
			else if (arr[mid] > element) {
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
			} else if (arr[mid] > element) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
