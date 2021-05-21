package com.geeksforgeeks.arrays;

public class Arrays {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 50, 70, 90 };
		displayArray(arr);
		System.out.println("searching " + search(arr, 20));
		System.out.println("max " + arr[findMax(arr)]);
		System.out.println("second max " + arr[findSecondMax(arr)]);
		System.out.println("third max " + arr[findThirdMax(arr)]);
		System.out.println("is sorted " + isSorted(arr));
		displayArray(arr);
		System.out.println("left rotate");
		leftRotateByN(arr, 5);
		displayArray(arr);
		System.out.println("print leader");
		printLeader(arr);
		System.out.println("reverse");
		reverse(arr);
		arr = new int[] { 10, 10, 20, 20, 30, 30, 30, 30 };
		System.out.println("remove duplicates");
		int size = removeDuplicatesSorted(arr);
		System.out.println(size);
		displayArray(arr);
		arr = new int[] { 10, 20, 0, 0, 30, 40, 0, 50 };
		displayArray(arr);
		System.out.println("move zeroes to end");
		moveZeroesToEndSecond(arr);
		displayArray(arr);
		arr = new int[] { 30, 10, 8, 2 };
		System.out.println("max difference " + findMaxDifference(arr));
		arr = new int[] { 1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10 };
		System.out.println("printFrequencySortedArray");
		printFrequencySortedArray(arr);
		arr = new int[] { 1, 5, 3, 1, 2, 8 };
		System.out.println("stock buy sell " + stockBuySell(arr));
		arr = new int[] { 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0 };
		System.out.println("max consecutive ones " + maxConsecutiveOnes(arr));
		arr = new int[] { -5, 1, -2, 3, -1, 2, -2 };
		System.out.println("longesConsecutiveSubArray " + longestConsecutiveSubArray(arr));
		System.out.println("longestConsecutiveSubArraySecond " + longestConsecutiveSubArraySecond(arr));
		arr = new int[] { 1, 2, 3, 4 };
		System.out.print("printSubArray ");
		printSubArray(arr);
	}

	public static int longestConsecutiveSubArraySecond(int[] arr) {
		int[] arr1 = new int[arr.length];
		arr1[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if ((arr1[i - 1] + arr[i]) > arr[i]) {
				arr1[i] = arr1[i - 1] + arr[i];
			} else {
				arr1[i] = arr[i];
			}
		}
		return arr1[findMax(arr1)];
	}

	public static int longestConsecutiveSubArray(int[] arr) {
		int final_max = arr[0];
		int instance_max = 0;
		for (int i = 0; i < arr.length; i++) {
			instance_max = arr[i];
			int sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum = sum + arr[j];
				if (sum > instance_max) {
					instance_max = sum;
				}
			}
			if (instance_max > final_max)
				final_max = instance_max;
		}
		return final_max;
	}

	public static void printSubArray(int[] arr) {
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if ((j + i) <= arr.length) {
					System.out.print("[ ");
					for (int k = j; k < (j + i); k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.print("]");
					System.out.print(" ");
				}
			}
		}
		System.out.println();
	}

	public static int maxConsecutiveOnes(int[] arr) {
		int result = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
			} else {
				if (count > result)
					result = count;
				count = 0;
			}
		}
		if (count > result)
			result = count;
		return result;
	}

	public static int stockBuySell(int[] arr) {
		int buy = arr[0];
		int sell = 0;
		int profit = 0;
		int instanceProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < buy) {
				buy = arr[i];
				sell = 0;
			}
			if (arr[i] > buy && arr[i] > sell) {
				sell = arr[i];
				instanceProfit = sell - buy;
			}
			if (arr[i] < sell) {
				profit = profit + instanceProfit;
				instanceProfit = 0;
				buy = arr[i];
				sell = 0;
			}
		}
		profit = profit + instanceProfit;
		return profit;
	}

	public static void printFrequencySortedArray(int[] arr) {
		int prev = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == prev) {
				count++;
			} else {
				System.out.println(prev + " -> " + count);
				count = 1;
			}
			prev = arr[i];
		}
		System.out.println(prev + " -> " + count);
	}

	public static int findMaxDifference(int[] arr) {
		int result = 0;
		int min = arr[0];
		result = arr[1] - min;
		for (int i = 1; i < arr.length; i++) {
			result = Math.max(result, arr[i] - min);
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return result;
	}

	public static void printLeader(int[] arr) {
		int max = arr[arr.length - 1];
		System.out.print(max + " ");
		for (int j = arr.length - 1; j >= 0; j--) {
			if (arr[j] > max) {
				max = arr[j];
				System.out.print(max + " ");
			}
		}
		System.out.println();
	}

	public static void leftRotateByN(int[] arr, int n) {
		reverseBetween(arr, 0, n - 1);
		reverseBetween(arr, n, arr.length - 1);
		reverseBetween(arr, 0, arr.length - 1);
	}

	public static void reverseBetween(int[] arr, int start, int last) {
		if (arr.length <= 1)
			return;
		while (start < last) {
			int temp = arr[start];
			arr[start] = arr[last];
			arr[last] = temp;
			start++;
			last--;
		}
	}

	public static void leftRotateByOne(int[] arr) {
		if (arr.length <= 1)
			return;
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
	}

	public static void moveZeroesToEndSecond(int[] arr) {
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[prev];
				arr[prev] = temp;
				prev++;
			}
		}
	}

	// Naive solution
	public static void moveZeroesToEnd(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i; j < arr.length; j++) {
					if (arr[j] != 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						break;
					}
				}
			}
		}
	}

	public static int removeDuplicatesSorted(int[] arr) {
		if (arr.length < 2) {
			return arr.length;
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
		return size;
	}

	public static void reverse(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {

			if ((i + 1) < arr.length && arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static int findThirdMax(int[] arr) {
		int index1 = 0;
		int min2 = Integer.MIN_VALUE;
		int min3 = Integer.MIN_VALUE;
		int index2 = -1;
		int index3 = -1;
		if (arr.length < 3) {
			return index3;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[index1]) {
				index3 = index2;
				min3 = min2;
				min2 = arr[index1];
				index2 = index1;
				index1 = i;
			} else if (arr[i] != arr[index1] && arr[i] > min2) {
				min3 = min2;
				index3 = index2;
			} else if (arr[i] != arr[index1] && arr[i] != min2 && arr[i] > min3) {
				index3 = i;
				min3 = arr[index3];
			}
		}
		return index3;
	}

	public static int findSecondMax(int[] arr) {
		int index1 = 0;
		int index2 = -1;
		if (arr.length < 2) {
			return index2;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[index1]) {
				index2 = index1;
				index1 = i;
			} else if (arr[i] != arr[index1] && arr[i] > arr[index2]) {
				index2 = i;
			}
		}
		return index2;
	}

	public static int findMax(int[] arr) {
		int index = 0;
		if (arr.length < 1) {
			return -1;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[index]) {
				index = i;
			}
		}
		return index;
	}

	public static boolean search(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return true;
			}
		}
		return false;
	}

	public static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
