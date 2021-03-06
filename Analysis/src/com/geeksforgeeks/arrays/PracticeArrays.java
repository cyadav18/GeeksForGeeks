package com.geeksforgeeks.arrays;

import java.util.ArrayList;

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
		arr = new int[] { 13, 14, 3, 3, 5, 2 };
		System.out.println("printLeaders");
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
		System.out.println("Print sub Array");
		printSubArray(arr);
		System.out.println("Sub Array Circular ");
		printSubArrayCircular(arr);
		arr = new int[] { 78, 25, 71, 84, 41, 9, 35, 84, 100, 31, 35, 89, 1, 93, 95, 1, 55, 50 };
		System.out.println("Stock buy and share ");
		printStockBuy(arr);
		System.out.println("minAdjDiff ");
		arr = new int[] { 1, 21, 5, 47, 71, 0, 36, 22, 64, 46, 18, 11, 73, 13, 57, 68, 8, 45, 99, 78, 3, 33, 17, 13, 30,
				26 };
		System.out.println(minAdjDiff(arr));
		arr = new int[] { 4, 14, 43, 36, 34, 33, 27, 17 };
		System.out.println(checkRotatedAndSorted(arr));
		arr = new int[] { 1, 2, 3, 4, 5 };
		convertToWave(arr);
		displayArray(arr);
	}

	public static void convertToWave(int arr[]) {

		if (arr.length < 1)
			return;
		for (int i = 1; i < arr.length; i = i + 2) {
			int prev = arr[i - 1];
			arr[i - 1] = arr[i];
			arr[i] = prev;
		}

	}

	public static boolean checkRotatedAndSorted(int arr[]) {

		int indexMin = 0;
		int indexMax = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[indexMin]) {
				indexMin = i;
			}
			if (arr[i] > arr[indexMax]) {
				indexMax = i;
			}
		}

		boolean increasing = true;
		int current_index_min = indexMin;
		int prev = arr[current_index_min];
		for (int j = 1; j < arr.length; j++) {
			current_index_min = current_index_min + 1;
			current_index_min = current_index_min % arr.length;
			if (arr[current_index_min] < prev) {
				increasing = false;
				break;
			}
			prev = arr[current_index_min];
		}
		if (increasing && indexMin != 0)
			return increasing;

		boolean decreasing = true;
		int current_index_max = indexMax;
		prev = arr[current_index_max];
		for (int j = 1; j < arr.length; j++) {
			current_index_max = current_index_max + 1;
			current_index_max = current_index_max % arr.length;
			if (arr[current_index_max] > prev) {
				decreasing = false;
				break;
			}
			prev = arr[current_index_max];
		}
		if (decreasing && indexMax != 0)
			return decreasing;

		return false;

	}

	/*
	 * Given an array Arr of n integers arranged in a circular fashion. Your task is
	 * to find the minimum absolute difference between adjacent elements.
	 */
	public static int minAdjDiff(int arr[]) {
		int min = Integer.MAX_VALUE;
		int prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int dif = arr[i] - prev;
			dif = Math.abs(dif);
			if (dif < min)
				min = dif;
			prev = arr[i];
		}
		return min;
	}

	/*
	 * The cost of stock on each day is given in an array A[] of size N. Find all
	 * the days on which you buy and sell the stock so that in between those days
	 * your profit is maximum.
	 * 
	 * Input: N = 7 A[] = {100,180,260,310,40,535,695} Output: 1 Explanation: One
	 * possible solution is (0 3) (4 6) We can buy stock on day 0, and sell it on
	 * 3rd day, which will give us maximum profit. Now, we buy stock on day 4 and
	 * sell it on day 6.
	 */

	public static void printStockBuy(int[] arr) {
		ArrayList<ArrayList<Integer>> outer = stockBuySell(arr);
		System.out.println(outer);

	}

//{100,180,260,310,40,535,695}
	public static ArrayList<ArrayList<Integer>> stockBuySell(int[] arr) {
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		int buy = arr[0];
		int sell = 0;
		int totalProfit = 0;
		int instantProfit = 0;
		int buyindex = 0;
		int sellindex = 0;
		ArrayList<Integer> inner = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= buy) {
				if (sell != 0) {
					instantProfit = sell - buy;
					inner.add(buyindex);
					inner.add(sellindex);
					outer.add(inner);
					inner = new ArrayList<Integer>();
					totalProfit = totalProfit + instantProfit;
				}
				buy = arr[i];
				buyindex = i;
				sell = 0;
			}
			if (arr[i] > buy && arr[i] > sell) {
				sell = arr[i];
				sellindex = i;
				instantProfit = sell - buy;
			}
			if (arr[i] > buy && arr[i] < sell) {
				inner.add(buyindex);
				inner.add(sellindex);
				outer.add(inner);
				inner = new ArrayList<Integer>();
				totalProfit = totalProfit + instantProfit;
				buy = arr[i];
				buyindex = i;
				sell = 0;
			}
		}
		if (sell != 0) {
			inner.add(buyindex);
			inner.add(sellindex);
			totalProfit = totalProfit + instantProfit;
			outer.add(inner);
		}
		return outer;

//		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
//		int buy = arr[0];
//		ArrayList<Integer> inner = new ArrayList<Integer>();
//		int buy_index = 0;
//		inner.add(buy_index);
//		int sell = 0;
//		int sell_index = 0;
//		int instant_profit = 0;
//		for (int i = 1; i < arr.length; i++) {
//			if (arr[i] > buy && arr[i] > sell) {
//				sell = arr[i];
//				int profit = sell - buy;
//				if (profit > instant_profit) {
//					instant_profit = profit;
//					sell_index = i;
//				}
//			}
//			if (arr[i] <= buy || (arr[i] > buy && arr[i] < sell)) {
//				if (sell != 0) {
//					inner.add(sell_index);
//					outer.add(inner);
//				}
//				inner = new ArrayList<Integer>();
//				instant_profit = 0;
//				buy = arr[i];
//				inner.add(i);
//				sell = 0;
//			}
//		}
//		if (sell != 0) {
//			inner.add(sell_index);
//			outer.add(inner);
//		}
//		System.out.println(outer);
//		return outer;
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
