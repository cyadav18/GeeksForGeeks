package com.geeksforgeeks.search;

import java.util.Arrays;

public class SearchingPractice {

	public static void main(String[] args) {
		int[] arr = { 67, 7, 0, 1, 2, 3, 4, 5, 68, 68, 45, 68, 87, 97, 84, 40, 27, 68 };
		Arrays.sort(arr);
		dispArray(arr);
		System.out.println("binarySearch " + binarySearch(arr, 68));
		System.out.println("binarySearchRecursive " + binarySearchRecursive(arr, 68, 0, arr.length - 1));
		System.out.println("binarySearchIndexOfFirst " + binarySearchIndexOfFirst(arr, 68, 0, arr.length - 1));
		System.out.println("binarySearchIndexOfFirst " + binarySearchIndexOfFirst(arr, 68));
		System.out.println("binarySearchIndexOfLast " + binarySearchIndexOfLast(arr, 68, 0, arr.length - 1));
		System.out.println("binarySearchIndexOfLast " + binarySearchIndexOfLast(arr, 68));
		arr = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println("countNumberOfOnesInBinary " + countNumberOfOnesInBinary(arr, 1));
		System.out.println("nearestSquare " + nearestSquare(25));
		arr = new int[] { 53, 7, 39, 25, 46, 49, 51, 86, 54, 98, 95, 4, 91, 88, 12, 3, 38, 51, 40, 24, 73, 16, 60, 42,
				36, 27, 76, 50, 15, 33 };
		mergeSort(arr, 0, arr.length - 1);
		dispArray(arr);
		searcInInfinate(arr, 98);

	}

	public static int searcInInfinate(int[] arr, int element) {
		if (arr[0] == element)
			return 0;
		return 0;
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		else {
			int mid = (low + high) / 2;
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
			if (arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while (i <= mid)
			temp[k++] = arr[i++];

		while (j <= high)
			temp[k++] = arr[j++];

		for (int l = 0; l < temp.length; l++)
			arr[low + l] = temp[l];
	}

	public static int nearestSquare(int num) {
		int low = 0;
		int high = num;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid * mid == num) {
				ans = mid;
				break;
			} else if (mid * mid > num) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int countNumberOfOnesInBinary(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
					high = mid - 1;
				} else {
					return arr.length - mid;
				}
			} else if (arr[mid] < element) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearchIndexOfLast(int[] arr, int element, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
					return binarySearchIndexOfLast(arr, element, mid + 1, high);
				} else {
					return mid;
				}
			} else if (arr[mid] < element) {
				return binarySearchIndexOfLast(arr, element, mid + 1, high);
			} else {
				return binarySearchIndexOfLast(arr, element, low, mid - 1);
			}
		}
	}

	public static int binarySearchIndexOfLast(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == element) {
				if (mid + 1 < arr.length && arr[mid] == arr[mid + 1])
					start = mid + 1;
				else
					return mid;
			} else if (arr[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearchIndexOfFirst(int[] arr, int element, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
					return binarySearchIndexOfFirst(arr, element, low, mid - 1);
				} else {
					return mid;
				}
			} else if (arr[mid] < element) {
				return binarySearchIndexOfFirst(arr, element, mid + 1, high);
			} else {
				return binarySearchIndexOfFirst(arr, element, low, mid - 1);
			}
		}
	}

	public static int binarySearchIndexOfFirst(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == element) {
				if (mid - 1 > 0 && arr[mid] == arr[mid - 1])
					end = mid - 1;
				else
					return mid;
			} else if (arr[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] arr, int element, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] < element) {
				return binarySearchRecursive(arr, element, mid + 1, high);
			} else {
				return binarySearchRecursive(arr, element, low, mid - 1);
			}
		}
	}

	public static int binarySearch(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void dispArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "(" + i + ") ");
		}
		System.out.println();
	}
}
