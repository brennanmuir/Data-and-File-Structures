package wmich.edu.cs3310.brennanmuir;

//Brennan Muir
//CS3310
//A4
//11/13/16

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author brennanmuir
 *
 */
public class ArrayMergeSort {

	/**
	 * @param list
	 * @return
	 */
	public ArrayList<String> mergeSort(ArrayList<String> list) {

		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> right = new ArrayList<String>();
		int center;

		if (list.size() == 1) {
			return list;
		} else {
			center = list.size() / 2;
			// copy the left half of list into the left.
			for (int i = 0; i < center; i++) {
				left.add(list.get(i));
			}

			// copy the right half of list into the new list.
			for (int i = center; i < list.size(); i++) {
				right.add(list.get(i));
			}

			// Sort the left and right halves of the list.
			left = mergeSort(left);
			right = mergeSort(right);

			// Merge the results back together.
			merge(left, right, list);
		}
		return list;
	}

	/**
	 * @param left
	 * @param right
	 * @param list
	 */
	private void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> list) {
		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;

		while (leftIndex < left.size() && rightIndex < right.size()) {
			if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
				list.set(listIndex, left.get(leftIndex));
				leftIndex++;
			} else {
				list.set(listIndex, right.get(rightIndex));
				rightIndex++;
			}
			listIndex++;
		}

		ArrayList<String> rest;
		int restIndex;
		if (leftIndex >= left.size()) {
			rest = right;
			restIndex = rightIndex;
		} else {
			rest = left;
			restIndex = leftIndex;
		}

		for (int i = restIndex; i < rest.size(); i++) {
			list.set(listIndex, rest.get(i));
			listIndex++;
		}
	}

}
