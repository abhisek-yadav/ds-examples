package com.sort.test;

public class InsertionSort {

	public static void insertionSort(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {

			int j = i - 1;
			int x = arr[i];

			while (j > -1 && x < arr[j]) {

				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = x;
		}
	}

	public static void main(String[] args) {

		int arr[] = { 10, 2, 5, 12, 3, 8, 6, 4, 7 };
		
		insertionSort(arr);

		for (int e : arr)
			System.out.print(e + ", ");

	}
}
