package com.geeksforgeeks.sorting;

public class PracticeSorting {

	public static void main(String[] args) {
		// {0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9}
		int[] arr = { 54, 42, 59, 51, 87, 90, 21, 15, 90, 71 };
		mergeSort(arr, 0, 9);
		disp_arr(arr);
		int[][] arr1 = { { 1, 7 }, { 8, 10 }, { 15, 18 }, { 3, 6 } };
		Range[] range = new Range[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			range[i] = new Range(arr1[i][0], arr1[i][1]);
		}
		Range.displayRanges(range);
		Range.mergeSort(range);
		arr1 = Range.removeIntersectionRange(range);
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		Range.displayRanges(range);
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

	public static void disp_arr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

class Range implements Comparable<Range> {
	private int start;
	private int end;

	public Range(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (end != other.end)
			return false;
		return true;
	}

	public int compareTo(Range o) {
		return this.start - o.start;
	}

	public String toString() {
		return "[start=" + start + ", end=" + end + "]";
	}

	public static int[][] removeIntersectionRange(Range[] arr) {
		Range prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (prev.end >= arr[i].start) {
				if (prev.end < arr[i].end) {
					prev.end = arr[i].end;
				}
			} else {
				prev = arr[i];
			}
		}
		int count = 1;
		prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (prev.end >= arr[i].end) {
				arr[i] = null;
			} else {
				count++;
				prev = arr[i];
			}
		}
		int[][] arr1 = new int[count][];
		for (int i = 0, j = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				arr1[j] = new int[2];
				arr1[j][0] = arr[i].start;
				arr1[j][1] = arr[i].end;
				j++;
			}
		}
		return arr1;
	}

	public static void mergeSort(Range[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(Range[] arr, int low, int high) {
		if (low >= high) {
			return;
		} else {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			mergeRange(arr, low, mid, high);
		}
	}

	private static void mergeRange(Range[] arr, int low, int mid, int high) {
		Range[] temp = new Range[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i].compareTo(arr[j]) <= 0) {
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

	public static void displayRanges(Range[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
