package wmich.edu.cs3310.brennanmuir;

//Brennan Muir
//CS3310
//A4
//11/13/16

import java.util.*;

/**
 * @author brennanmuir
 *
 */
public class LinkedMergeSort {

	/**
	 * @param input
	 * Constructor
	 */
	public LinkedMergeSort(Comparable[] input) {
		System.out.print("Before Sorting: ");
		System.out.println(Arrays.toString(input));

		mergeSort(input);

		System.out.print("After Sorting: ");
		System.out.println(Arrays.toString(input));
	}

	
	/**
	 * @param input
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] input) {
		// if list is empty return list
		if (input.length <= 1) {
			return input;
		}

		// split the array in two halves
		Comparable[] left = new Comparable[input.length / 2];
		Comparable[] right = new Comparable[input.length - left.length];
		System.arraycopy(input, 0, left, 0, left.length);
		System.arraycopy(input, left.length, right, 0, right.length);

		// use recursive sorting for both halves
		mergeSort(left);
		mergeSort(right);

		// merge the halves together
		merge(left, right, input);
		return input;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 * @param result
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] left, Comparable[] right, Comparable[] result) {

		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;

		// while index is still in bounds
		while (leftIndex < left.length && rightIndex < right.length) {
			// compare left and right elements
			if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
				result[mergedIndex] = left[leftIndex];
				leftIndex++;
			} else {
				result[mergedIndex] = right[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}
		// copy the elements from left half
		System.arraycopy(left, leftIndex, result, mergedIndex, left.length - leftIndex);
		// copy the elements from right half
		System.arraycopy(right, rightIndex, result, mergedIndex, right.length - rightIndex);
	}

}
