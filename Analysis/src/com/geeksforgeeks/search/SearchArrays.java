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
		System.out.println("countOccurrence " + countOccurrence(arr, 23));
		System.out.println("countOccurrenceEfficient " + countOccurrenceEfficient(arr, 23));
		System.out.println("squareRoot " + squareRoot(15));
		System.out.println("squareRootEfficient " + squareRootEfficient(15));
		arr = new int[] { 12, 15, 21, 23, 34, 45, 56, 67, 78, 89, 90, 100, 110, 120 };
		System.out.println("searchInInfinateArray " + searchInInfinateArray(arr, 12));
		arr = new int[] { 34, 45, 56, 67, 78, 12, 15, 21, 23 };
		System.out.println("searchInSortedRotatedArray " + searchInSortedRotatedArray(arr, 12));
		arr = new int[] { 2, 4, 8, 9, 11, 12, 20, 30 };
		System.out.println("findAPairwithGivenSumSortedArray " + findAPairwithGivenSumSortedArray(arr, 23));

	}

	public static boolean findAPairwithGivenSumSortedArray(int[] arr, int sum) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int instantSum = arr[low] + arr[high];
			if (instantSum == sum)
				return true;
			if (instantSum > sum)
				high--;
			if (instantSum < sum)
				low++;
		}
		return false;
	}

	/*
	 * AT ANY POINT ONE HALF IS ALWAYS SORTED
	 */
	public static int searchInSortedRotatedArray(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[low] < arr[mid]) {
				if (element >= arr[low] && element < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (element > arr[mid] && element <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	// Unbounded binary search
	public static int searchInInfinateArray(int[] arr, int element) {
		if (arr[0] == element)
			return 0;
		int low = 1;
		int high = 2 * low;
		while (high < arr.length && arr[high] <= element) {
			low = high;
			high = 2 * low;
		}
		if (high >= arr.length) {
			high = arr.length - 1;
		}
		if (arr[high] == element)
			return high;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element)
				return mid;
			else if (arr[mid] > element) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int squareRootEfficient(int num) {
		int ans = 0;
		int low = 0;
		int high = num;
		while (low <= high) {
			int mid = (low + high) / 2;
			int midSqr = mid * mid;
			if ((midSqr) == num)
				return mid;
			if (midSqr > num) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int squareRoot(int num) {
		int result = 1;
		for (int i = 2; (i * i) <= num; i++) {
			result = i;
		}
		return result;
	}

	public static int countOccurrenceEfficient(int[] arr, int element) {
		int first = searchFirstOccurrence(arr, element);
		int last = searchLastOccurrence(arr, element);
		return last - first + 1;
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
