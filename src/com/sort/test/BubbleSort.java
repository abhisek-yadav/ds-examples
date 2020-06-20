package com.sort.test;

public class BubbleSort {

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {

			for (int j = 1; j < n - i; j++) {

				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				}
			}
		}

	}

	public static void main(String[] args) {

		int arr[] = { 10, 2, 5, 12, 3, 8, 6, 4, 7 };

		bubbleSort(arr);

		for (int e : arr)
			System.out.print(e + ", ");

	}

}
