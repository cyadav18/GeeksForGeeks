package Threads;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		printNbinocci(3, 10);
		int[] arr = { 1, 3, 5, 2, 2 };
		display_array(arr);
		System.out.println(equlibriumPoint(arr));
		System.out.println(equlibriumPointEfficient(arr));

		int[][] arr1 = { { 7, 8, 9 }, { 13, 14, 15 }, { 10, 11, 12 }, { 4, 5, 6 }, { 1, 2, 3 } };
		Arrays.sort(arr1, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		for (int[] interval : arr1) {
			System.out.println(Arrays.toString(interval));
		}
	}

	public static boolean equlibriumPointEfficient(int[] arr) {
		int right_sum = 0;
		for (int i = 0; i < arr.length; i++)
			right_sum = right_sum + arr[i];
		int left_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				left_sum = 0;
			} else {
				left_sum = left_sum + arr[i - 1];
			}
			if (i == arr.length - 1) {
				right_sum = 0;
			} else {
				right_sum = right_sum - arr[i];
			}
			if (left_sum == right_sum) {
				return true;
			}
		}
		return false;
	}

	public static boolean equlibriumPoint(int[] arr) {
		int[] psum = prefixSum(arr);
		int left_sum = 0;
		int right_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				left_sum = 0;
			} else {
				left_sum = psum[i - 1];
			}
			if (i == arr.length - 1) {
				right_sum = 0;
			} else {
				right_sum = psum[psum.length - 1] - psum[i];
			}
			if (left_sum == right_sum) {
				System.out.println(i);
				return true;
			}
		}
		return false;
	}

	public static int[] prefixSum(int[] arr) {
		int[] prefixSum = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			prefixSum[i] = sum;
		}
		return prefixSum;
	}

	public static void display_array(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void printNbinocci(int n, int upto) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = 0;
			System.out.print(arr[i] + " ");
		}
		arr[arr.length - 1] = 1;
		System.out.print(arr[arr.length - 1] + " ");
		int array_sum = 1;
		for (int i = n; i < upto; i++) {
			System.out.print(array_sum + " ");
			int sum = array_sum - arr[i % n] + array_sum;
			arr[i % n] = array_sum;
			array_sum = sum;
		}
		System.out.println();
	}
}

class ReadArray implements Runnable {

	static int totalSum = 0;
	int start;
	int end;

	public void comupteSum(int[] arr) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum = sum + arr[i];
		}
	}

	public synchronized void updateSum(int sum) {
		ReadArray.totalSum += sum;
	}

	public void run() {
		comupteSum(null);
	}

}