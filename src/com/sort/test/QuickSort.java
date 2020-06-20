package com.sort.test;

public class QuickSort {

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * Return the index of pivot element
	 * 
	 * @return
	 */
	private static int partition(int[] arr, int l, int h) {

		int pivot = arr[l];

		int i = h;

		for (int j = h; j > l; j--) {

			if (pivot < arr[j]) {
				swap(arr, i, j);
				i--;
			}
		}
		swap(arr, l, i);

		return i;

	}

	public static void quickSort(int arr[], int l, int h) {

		if (l < h) {

			int pos = partition(arr, l, h);

			quickSort(arr, l, pos - 1);
			quickSort(arr, pos + 1, h);

		}
	}

	public static void main(String[] args) {

		int arr[] = { 10, 2, 5, 12, 3, 8, 6, 4, 7 };

		quickSort(arr, 0, arr.length - 1);

		for (int e : arr)
			System.out.print(e + ", ");

	}

}
