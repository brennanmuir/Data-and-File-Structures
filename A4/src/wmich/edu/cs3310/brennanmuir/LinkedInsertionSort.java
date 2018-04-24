package wmich.edu.cs3310.brennanmuir;

//Brennan Muir
//CS3310
//A4
//11/13/16

import java.util.ArrayList;

/**
 * @author brennanmuir
 *
 */
public class LinkedInsertionSort {

	/**
	 * @param linkedArray
	 * @return
	 */
	public static String[] insertionSort(String[] linkedArray) {

		System.out.print("\nBefore Sorting: ");
		System.out.print("[");
		for (String s : linkedArray) {
			System.out.print(s + ", ");
		}
		System.out.print("]\n");
		String key;
		int i;
		for (int j = 1; j < linkedArray.length; j++) {
			key = linkedArray[j];
			i = j - 1;
			while (i >= 0) {
				if (key.compareTo(linkedArray[i]) > 0) {
					break;
				}
				linkedArray[i + 1] = linkedArray[i];
				i--;
			}
			linkedArray[i + 1] = key;
		}
		return linkedArray;
	}
}
