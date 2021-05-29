package com.geeksforgeeks.recursion;

public class WordsPhoneBook {
	static char[][] arr = new char[][] { { '\0' }, { '\0' }, { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' },
			{ 'J', 'K', 'L' }, { 'M', 'N', 'O' }, { 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y', 'Z' },
			{ '*' }, { '#' } };

	public static void main(String[] args) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		printWrapper("223");
	}

	public static void printWrapper(String s) {
		printWords(arr, s, "");
	}

	public static void printWords(char[][] arr, String giveString, String current) {
		if (giveString.length() == 1) {
			printArray(arr, Integer.parseInt(giveString), current);
			return;
		} else {

			String current_number = "" + giveString.charAt(0);
			int index = Integer.parseInt(current_number);
			for (int j = 0; j < arr[index].length; j++) {
				current = current + arr[index][j];
				printWords(arr, giveString.substring(1), current);
				current = current.replace(arr[index][j] + "", "");
			}

		}
	}

	public static void printArray(char[][] arr, int i, String s) {
		for (int k = 0; k < arr[i].length; k++) {
			System.out.print(s + arr[i][k] + " ");
		}
		System.out.println();
	}
}
