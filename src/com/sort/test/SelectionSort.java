package com.sort.test;

public class SelectionSort {

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {

			int k = i;
			for (int j = i; j < n; j++) {

				if (arr[k] > arr[j]) {
					k = j;
				}
			}

			swap(arr, i, k);

		}

	}

	public static void main(String[] args) {

		int arr[] = { 10, 2, 5, 12, 3, 8, 6, 4, 7 };
		
		selectionSort(arr);

		for (int e : arr)
			System.out.print(e + ", ");

	}
}
