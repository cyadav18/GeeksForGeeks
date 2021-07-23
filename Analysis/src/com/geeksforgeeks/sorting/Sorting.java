package com.geeksforgeeks.sorting;

public class Sorting {

//	https://onlineintegertools.com/create-integer-array
	public static void main(String[] args) {
		int arr[] = { 14, 33, 27, 10, 35, 19, 42, 44 };
		bubbleSort(arr);
		arr = new int[] { 14, 33, 27, 10, 35, 19, 42, 44 };
		selectionSort(arr);
		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		insertionSort(arr);
		disp_arr(arr);
		int[] arr1 = { 4, 23, 7, 39, 19, 12, 9, 14, 14 };
		insertionSort(arr1);
		disp_arr(arr1);
		arr1 = mergeTwoSortedArray(arr, arr1);
		disp_arr(arr1);
		int[] arr2 = { 10, 14, 19, 27, 33, 35, 42, 44, 2, 4, 7, 9, 14, 19, 23, 39, 45 };
		merge(arr2, 0, 2, 4);
		mergeSort(arr1, 0, arr1.length - 1);
		disp_arr(arr1);
		int[] a1 = { 79, 32, 83, 93, 62, 6, 21, 21, 37, 31, 21, 13 };
		int[] a2 = { 51, 12, 84, 65, 83, 21, 21, 21, 61, 17, 31, 52 };
		mergeSort(a1, 0, a1.length - 1);
		mergeSort(a2, 0, a2.length - 1);
		disp_arr(a1);
		disp_arr(a2);
		printCommonElementsBetweenSorted(a1, a2);
		printUnionBetweenSorted(a1, a2);
		arr1 = new int[] { 8, 1, 6, 2 };
		System.out.println("countInversions " + countInversions(arr1, 0, arr1.length - 1));
		int[] arr3 = { 10, 47, 94, 62, 45, 10, 8, 46, 48, 62, 48, 48 };
		nivePartition(arr3, 0, arr.length - 1, 7);
		disp_arr(arr3);
	}

	public static void partitionArray(int[] arr, int low, int high) {
		int partition_element = arr[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= partition_element) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
	}

	public static int nivePartition(int[] arr, int low, int high, int pivot) {

		swap(arr, high, pivot);
		int[] temp = new int[high - low + 1];
		int k = 0;
		for (int i = low; i <= high; i++) {
			if (arr[i] <= arr[high]) {
				temp[k++] = arr[i];
			}
		}
		int res = low + k - 1;
		for (int i = low; i <= high; i++) {
			if (arr[i] > arr[high]) {
				temp[k++] = arr[i];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			arr[low + i] = temp[i];
		}
		return res;
	}

	/*
	 * Count Inversions in an array | Set 1 (Using Merge Sort) Difficulty Level :
	 * Hard Last Updated : 28 Jun, 2021
	 * 
	 * Inversion Count for an array indicates – how far (or close) the array is from
	 * being sorted. If the array is already sorted, then the inversion count is 0,
	 * but if the array is sorted in the reverse order, the inversion count is the
	 * maximum. Formally speaking, two elements a[i] and a[j] form an inversion if
	 * a[i] > a[j] and i < j Example:
	 * 
	 * Input: arr[] = {8, 4, 2, 1} Output: 6
	 * 
	 * Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1),
	 * (4, 1), (2, 1).
	 * 
	 * 
	 * Input: arr[] = {3, 1, 2} Output: 2
	 * 
	 * Explanation: Given array has two inversions: (3, 1), (3, 2)
	 */
	public static int countInversions(int[] arr, int low, int high) {
		if (low >= high) {
			return 0;
		} else {
			int mid = low + (high - low) / 2;
			int left = countInversions(arr, low, mid);
			int right = countInversions(arr, mid + 1, high);
			int result = mergeAndCountInversion(arr, low, mid, high);
			return result + left + right;
		}
	}

	public static int mergeAndCountInversion(int[] arr, int low, int mid, int high) {
		int result = 0;
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				result = result + mid - i + 1;
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		for (int l = 0; l < temp.length; l++) {
			arr[low + l] = temp[l];
		}
		return result;
	}

	public static void printUnionBetweenSorted(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (i > 0 && arr1[i] == arr1[i - 1]) {
				i++;
				continue;
			}
			if (j > 0 && arr1[j] == arr1[j - 1]) {
				j++;
				continue;
			}
			if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i++] + " ");
			} else if (arr2[j] < arr1[i]) {
				System.out.print(arr2[j++] + " ");
			}
		}
		while (i < arr1.length) {
			if (i > 0 && arr1[i] == arr1[i - 1]) {
				i++;
				continue;
			} else {
				System.out.print(arr1[i++] + " ");
			}
		}
		while (j < arr2.length) {
			if (j > 0 && arr2[j] == arr2[j - 1]) {
				j++;
				continue;
			} else {
				System.out.print(arr2[j++] + " ");
			}
		}
		System.out.println();
	}

	public static void printCommonElementsBetweenSorted(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				if (i > 0 && arr1[i - 1] != arr1[i])
					System.out.print(arr1[i] + " ");
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr1[i]) {
				j++;
			}
		}
		System.out.println();
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		} else {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		for (int l = 0; l < temp.length; l++) {
			arr[low + l] = temp[l];
		}
	}

	public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		int[] res = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				res[k++] = arr1[i++];
			} else {
				res[k++] = arr2[j++];
			}
		}
		while (i < arr1.length) {
			res[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			res[k++] = arr2[j++];
		}
		return res;
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
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
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