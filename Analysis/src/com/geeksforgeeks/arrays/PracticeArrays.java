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
		arr = new int[] { 16, 17, 4, 3, 5, 2 };
		printLeaders(arr);
		arr = new int[] { 7, 9, 5, 6, 3, 2 };
		System.out.println("findMaxdifference " + findMaxdifferenceSecond(arr));
		arr = new int[] { 1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10 };
		System.out.println("printFrequencySortedArray");
		printFrequencySortedArray(arr);
		arr = new int[] { 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0 };
		System.out.println("max consecutive ones " + maxConsecutiveOnes(arr));
		arr = new int[] { 2, 3, 4, 5, 7 };
		System.out.println("longestConsecutiveSubArray " + longestConsecutiveSubArray(arr));
		arr = new int[] { 1, 2, 3, 4 };
		printSubArray(arr);
		printSubArrayCircular(arr);
	}

	public static void printSubArrayCircular(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print("[ ");
				for (int k = j; k <= (i + j); k++) {
					int index = k;
					if (index >= arr.length) {
						index = index % arr.length;
					}
					System.out.print(arr[index] + " ");
				}
				System.out.print("] ");
			}
		}
		System.out.println();
	}

	public static void printSubArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if ((i + j) < arr.length) {
					System.out.print("[ ");
					for (int k = j; k <= (i + j); k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.print("] ");
				}
			}
		}
		System.out.println();
	}

	public static int longestConsecutiveSubArray(int[] arr) {
		int final_max = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] + max > arr[i]) {
				max = arr[i] + max;
			} else {
				max = arr[i];
			}
			if (max > final_max) {
				final_max = max;
			}
		}
		return final_max;
	}

	public static int maxConsecutiveOnes(int[] arr) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
			} else {
				if (count > max)
					max = count;
				count = 0;
			}
		}
		return max;
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

	public static int findMaxdifferenceSecond(int[] arr) {
		int max_dif = arr[1] - arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_dif = Math.max(max_dif, arr[i] - min);
			if (arr[i] < min)
				min = arr[i];
		}
		return max_dif;
	}

	public static int findMaxdifference(int[] arr) {
		int min_index = 0;
		int max_index = 1;
		int max_dif = arr[max_index] - arr[min_index];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[max_index]) {
				max_index = i;
			}
			if (arr[i] < arr[min_index]) {
				min_index = i;
			}
			if (max_index > min_index) {
				int result = arr[max_index] - arr[min_index];
				if (result > max_dif) {
					max_dif = result;
				}
			}
		}
		return max_dif;
	}

	public static void printLeaders(int[] arr) {
		int max = arr[arr.length - 1];
		System.out.print(max + " ");
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				System.out.print(max + " ");

			}
		}
		System.out.println();
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
