package com.geeksforgeeks.arrays;

import java.util.ArrayList;

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
		displayArray(arr);
		arr = new int[] { 10, 10, 20, 20, 30, 30, 30, 30 };
		System.out.println("remove duplicates");
		int size = removeDuplicatesSorted(arr);
		System.out.println(size);
		displayArray(arr);
		arr = new int[] { 10, 20, 0, 0, 30, 40, 0, 50 };
		displayArray(arr);
		System.out.println("move zeroes to end");
		moveZeroesToEndEfficient(arr);
		displayArray(arr);
		arr = new int[] { 30, 10, 8, 2 };
		System.out.println("max difference " + findMaxDifference(arr));
		arr = new int[] { 1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10 };
		System.out.println("printFrequencySortedArray");
		printFrequencySortedArray(arr);
		arr = new int[] { 78, 25, 71, 84, 41, 9, 35, 84, 100, 31, 35, 89, 1, 93, 95, 1, 55, 50 };
		arr = new int[] { 100, 180, 260, 310, 40, 535, 695 };
		System.out.println("stockBuySell " + stockBuySell(arr));
		arr = new int[] { 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0 };
		System.out.println("max consecutive ones " + maxConsecutiveOnes(arr));
		arr = new int[] { -5, 1, -2, 3, -1, 2, -2 };
		System.out.println("maxSubArray " + maxSubArray(arr));
		System.out.println("maxSubArrayEfficient " + maxSubArrayEfficient(arr));
		arr = new int[] { 1, 2, 3, 4 };
		System.out.print("printSubArray ");
		printSubArray(arr);
		arr = new int[] { 82, 11, 38, 24, 60, 35, 77, 10, 39, 20, 78, 96, 18, 87, 6, 26, 79, 22, 26, 84, 32, 94, 11, 22,
				12, 70, 35, 77, 16, 67, 82, 89, 70, 61, 67, 17, 91, 58, 83, 76, 35, 64, 88, 77, 21, 3, 98, 5, 32, 19,
				12, 67, 18, 47, 35, 76, 82, 67, 90, 5, 95, 7, 1, 74, 90, 1 };
		System.out.println("maxLengthEvenOddSubbArray " + maxLengthEvenOddSubbArray(arr));
		System.out.println("minSubArray " + minSubArray(arr));
		arr = new int[] { -5, -2, -3, -4 };
		System.out.println("maxSumSubarrayCircular " + maxSumSubarrayCircular(arr));
		System.out.println("maxSumSubarrayCircularEfficient " + maxSumSubarrayCircularEfficient(arr));
		System.out.println("minSubArray New " + minSubArray(arr));
		arr = new int[] { 8, 7, 6, 8, 6, 6, 6, 6 };
		System.out.println("majorityElement " + majorityElement(arr));
		System.out.println("majorityEfficient " + majorityEfficient(arr));
		System.out.println("printMinimumGroupFlipsEfficient");
		arr = new int[] { 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1 };
		printMinimumGroupFlipsEfficient(arr);
		arr = new int[] { 1, 8, 30, -5, 20, 7 };
		System.out.println("maxSumSubArrayOfK " + maxSumSubArrayOfK(arr, 3));
		System.out.println("maxSumSubArrayOfKEqualToSum " + maxSumSubArrayOfKEqualToSum(arr, 3, 32));
		arr = new int[] { 1, 5, 20, 3, 10, 5 };
		System.out.println("maxSumSubArrayEqualToSum " + maxSumSubArrayEqualToSum(arr, 1));
		System.out.println("printNbonacciNumberupToM");
		printNbonacciNumberupToM(4, 12);
		arr = new int[] { 3, 4, 8, -9, 20, 6 };
		System.out.println("findEqulibriumpoint " + findEqulibriumpoint(arr));
		System.out.println("findEqulibriumpointEfficient " + findEqulibriumpointEfficient(arr));
		arr = new int[] { 1, 3, 4, 0, 4 };
		System.out.println(
				"checkIfArrayCanBeDividedIntoThreeEqualParts " + checkIfArrayCanBeDividedIntoThreeEqualParts(arr));
		arr = new int[] { 78, 25, 71, 84, 41, 9, 35, 84, 100, 31, 35, 89, 1, 93, 95, 1, 55, 50 };
//		arr = new int[] { 100, 180, 260, 310, 40, 535, 695 };
		System.out.println("stockBuySell " + stockBuySell(arr));
		System.out.println("stockBuySell " + printMaxProfit(arr));
		arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("trappingRainWater " + trappingRainWater(arr));
		System.out.println("trappingRainWaterEfficient " + trappingRainWaterEfficient(arr));
	}

	/*
	 * Given n non-negative integers representing an elevation map where the width
	 * of each bar is 1, compute how much water it is able to trap after raining.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {2, 0, 2} Output: 2 Input: arr[] = {3, 0, 2, 0, 4} Output: 7
	 *
	 * T = O(n) M = O(n)
	 */
	public static int trappingRainWaterEfficient(int[] arr) {
		int quantity = 0;
		int[] lmax = new int[arr.length];
		int[] rmax = new int[arr.length];
		lmax[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				lmax[i] = arr[i];
				max = arr[i];
			} else {
				lmax[i] = max;
			}

		}
		max = arr[arr.length - 1];
		rmax[rmax.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				rmax[i] = arr[i];
				max = arr[i];
			} else {
				rmax[i] = max;
			}
		}
		for (int i = 1; i < arr.length - 1; i++) {
			quantity = quantity + Math.min(lmax[i], rmax[i]) - arr[i];
		}
		return quantity;
	}

	/*
	 * O(n^2)
	 */
	public static int trappingRainWater(int[] arr) {
		int quantity = 0;
		for (int i = 1; i < arr.length - 1; i++) {

			int lmax = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] > lmax)
					lmax = arr[j];
			}

			int rmax = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > rmax)
					rmax = arr[j];
			}

			quantity = quantity + Math.min(lmax, rmax) - arr[i];
		}
		return quantity;
	}

	public static int printMaxProfit(int[] arr) {
		int buy = arr[0];
		int sell = 0;
		int total_profit = 0;
		int instant_profit = 0;
		int buy_index = 0;
		int sell_index = 0;
		ArrayList<Integer> inner = new ArrayList<Integer>();
		inner.add(buy_index);
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > buy && arr[i] > sell) {
				sell = arr[i];
				int profit = sell - buy;
				if (profit > instant_profit) {
					sell_index = i;
					instant_profit = profit;
				}
			}
			if (arr[i] <= buy || (arr[i] > buy && arr[i] < sell)) {
				total_profit = total_profit + instant_profit;
				if (sell != 0) {
					inner.add(sell_index);
					outer.add(inner);
				}
				inner = new ArrayList<Integer>();
				instant_profit = 0;
				buy = arr[i];
				inner.add(i);
				sell = 0;
			}
		}
		if (sell != 0) {
			total_profit = total_profit + instant_profit;
			inner.add(sell_index);
			outer.add(inner);
		}
		System.out.println(outer);
		return total_profit;
	}

	public static boolean checkIfArrayCanBeDividedIntoThreeEqualParts(int[] arr) {
		boolean divide = false;
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
		int rem = 0;
		if (sum % 3 == 0)
			rem = sum / 3;
		else
			return divide;
		sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (arr[i] != 0 && sum % rem == 0)
				System.out.print(i + " ");
		}
		System.out.println();
		return divide;
	}

	public static boolean findEqulibriumpointEfficient(int[] arr) {
		boolean equlibrium = false;
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
		int leftSum = 0;
		int rightSum = sum;
		for (int i = 0; i < arr.length; i++) {
			if (i - 1 >= 0) {
				leftSum = leftSum + arr[i - 1];
			}
			rightSum = rightSum - arr[i];
			if (leftSum == rightSum) {
				equlibrium = true;
			}
		}
		return equlibrium;
	}

	/*
	 * T O(n) S O(n)
	 */

	public static boolean findEqulibriumpoint(int[] arr) {
		boolean equlibrium = false;
		int[] prefixArray = new int[arr.length];
		prefixArraySum(arr, prefixArray);
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < prefixArray.length; i++) {
			if (i - 1 >= 0)
				leftSum = prefixArray[i - 1];
			rightSum = prefixArray[prefixArray.length - 1] - prefixArray[i];
			if (leftSum == rightSum) {
				equlibrium = true;
			}
		}
		return equlibrium;
	}

	public static void prefixArraySum(int[] arr, int[] prefix) {
		prefix[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
	}
	/*
	 * The idea is this we will create a simple 1st we will have a array of give
	 * nbinocci eg:- 3 [0,0,1] we have TS of the array at any point of time :) so
	 * for 1st we will print TS next is that when computing next sum which will be
	 * TS+TS-element to be replaced with in the array before appending TS after
	 * printing
	 */

	public static void printNbonacciNumberupToM(int N, int M) {
		int[] arr = new int[N];
		for (int i = 0; i < (N - 1); i++) {
			arr[i] = 0;
			System.out.print(arr[i] + " ");
		}
		arr[N - 1] = 1;
		int totalSum = 1;
		System.out.print(totalSum + " ");
		for (int i = N; i < M; i++) {
			System.out.print(totalSum + " ");
			int prev = arr[i % N];
			arr[i % N] = totalSum;
			totalSum = totalSum + totalSum - prev;

		}
		System.out.println();
	}

	public static boolean maxSumSubArrayEqualToSum(int[] arr, int sum) {
		int instanstSum = arr[0];
		int start = 0;
		for (int i = 1; i < arr.length; i++) {

			while (instanstSum >= sum) {
				if (instanstSum == sum)
					return true;
				instanstSum = instanstSum - arr[start];
				start++;
			}
			instanstSum = instanstSum + arr[i];
		}
		while (instanstSum >= sum) {
			if (instanstSum == sum)
				return true;
			instanstSum = instanstSum - arr[start];
			start++;
		}
		return false;
	}

	/*
	 * arr = [1,8,30,-5,20,7] k = 3; o/p = 45; for sub array of size k , we need to
	 * find the maximum element
	 * 
	 * one way is iterating each element by k further elements and returning maxsum
	 * 
	 * other way is sliding window technique 1+8+30 = 39 for next sub array take 39
	 * - (1) + (-5) = 33 for next sub array take 33- (8) + + 20 = 45 so on
	 */

	public static boolean maxSumSubArrayOfKEqualToSum(int[] arr, int k, int sum) {
		int instant_max = 0;
		for (int i = 0; i < k; i++) {
			instant_max = instant_max + arr[i];
			if (instant_max == sum)
				return true;
		}
		for (int i = k; i < arr.length; i++) {
			instant_max = instant_max + arr[i] - arr[i - k];
			if (instant_max == sum)
				return true;
		}
		return false;
	}

	public static int maxSumSubArrayOfK(int[] arr, int k) {
		int max_sum = 0;
		int instant_max = 0;
		for (int i = 0; i < k; i++) {
			instant_max = instant_max + arr[i];
		}
		max_sum = instant_max;
		for (int i = k; i < arr.length; i++) {
			instant_max = instant_max + arr[i] - arr[i - k];
			if (instant_max > max_sum)
				max_sum = instant_max;
		}
		return max_sum;
	}

	/*
	 * i/p [1,1,0,0,0,1] o/p Flip From 2 to 4
	 * 
	 * [1,0,0,0,1,0,0,1,1,1,1] o/p Flip from 1 to 2 Flip from 5 to 6
	 * 
	 * [1,1,1] o/p
	 * 
	 * [0,1] o/p Flip from 1 to 1 or o/p Flip for 0 to 0
	 * 
	 * The property which we are using in efficient algorithm is that for any given
	 * binary number 1101100 the count of second occurrence will be equal or less
	 * that 1st occurrence traverse and replace the second occurrence
	 */
	public static void printMinimumGroupFlipsEfficient(int[] arr) {
		int first = arr[0];
		int count = 0;
		int from = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != first) {
				if (count == 0)
					from = i;
				count++;
			} else {
				if (count > 0)
					System.out.print("From " + from + " to " + (from + count - 1) + " ");
				count = 0;
			}
		}
		if (count > 0)
			System.out.print("From " + from + " to " + (from + count - 1) + " ");
		System.out.println();
	}

	public static void printMinimumGroupFlips(int[] arr) {
		int consecutiveOnes = findConsecutive(arr, 1);
		int consecutiveZeroes = findConsecutive(arr, 0);
		if (consecutiveZeroes <= consecutiveOnes) {
			flipConsecutive(arr, 0);
		} else {
			flipConsecutive(arr, 1);
		}

	}

	public static void flipConsecutive(int[] arr, int num) {
		int count = 0;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				if (count == 0)
					start = i;
				count++;
			}
			if (arr[i] != num && count > 0) {
				System.out.println("From " + start + " to " + (start + count - 1));
				count = 0;
			}
		}
		if (count > 0)
			System.out.println("From " + start + " to " + (start + count - 1));
	}

	public static int findConsecutive(int[] arr, int num) {
		int count = 0;
		int totalCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				count++;
			} else {
				if (count > 0)
					totalCount++;
				count = 0;
			}
		}
		if (count > 1)
			totalCount++;
		return totalCount;
	}

	public static int majorityEfficient(int[] arr) {
		// Find majority
		int result = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (result == arr[i])
				count++;
			else
				count--;
			if (count == 0) {
				result = arr[i];
				count = 1;
			}
		}
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == result)
				count++;
		}
		if (count > arr.length / 2)
			return result;
		return -1;
	}

	public static int majorityElement(int[] arr) {
		int majority_count = 0;
		int majority_index = 0;
		for (int i = 0; i < arr.length; i++) {
			int instance_count = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[i] == arr[j])
					instance_count++;
			}
			if (instance_count > majority_count) {
				majority_count = instance_count;
				majority_index = i;
			}
		}
		if (majority_count > arr.length / 2)
			return arr[majority_index];
		else
			return -1;
	}

	public static int maxSumSubarrayCircularEfficient(int[] arr) {
		int normal_max = maxSubArrayEfficient(arr);
		int sum_arr = arrSum(arr);
		int min_max = minSubArray(arr);
		int sum_circular = sum_arr - min_max;
		if (normal_max < 0)
			return normal_max;
		if (normal_max > sum_circular) {
			return normal_max;
		}
		return sum_circular;
	}

	public static int arrSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	public static int minSubArray(int[] arr) {
		int final_min = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] + min) < arr[i]) {
				min = arr[i] + min;
			} else {
				min = arr[i];
			}
			if (min < final_min) {
				final_min = min;
			}
		}
		return final_min;
	}

	public static int minSumSubArray(int[] arr) {
		int result = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = max + arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return result;
	}

	public static int maxSumSubarrayCircular(int[] arr) {
		int final_max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			int max = arr[i];
			int sum = arr[i];
			int current_index = i + 1;
			int j = 1;
			while (j < arr.length) {
				current_index = current_index % (arr.length);
				sum = sum + arr[current_index];
				if (sum > max)
					max = sum;
				current_index++;
				j++;
			}
			if (max > final_max)
				final_max = max;
		}
		return final_max;
	}

	public static int maxLengthEvenOddSubbArray(int[] arr) {
		int max_length = 1;
		int prev = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (((prev & 1) == 1) && ((arr[i] & 1) == 0)) {
				count++;
			} else if (((prev & 1) == 0) && ((arr[i] & 1) == 1)) {
				count++;
			} else {
				count = 1;
			}
			if (count > max_length)
				max_length = count;
			prev = arr[i];
		}

		return max_length;
	}

	public static int maxSubArrayEfficient(int[] arr) {
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

	public static int maxSubArray(int[] arr) {
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
			if (arr[i] <= buy) {
				if (sell != 0) {
					instanceProfit = sell - buy;
					profit = profit + instanceProfit;
				}
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
		if (sell != 0)
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

	public static void moveZeroesToEndEfficient(int[] arr) {
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
