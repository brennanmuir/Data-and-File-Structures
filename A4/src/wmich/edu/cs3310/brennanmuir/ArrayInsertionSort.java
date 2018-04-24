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
public class ArrayInsertionSort {
	/**
	 * @param list
	 * @return
	 */
	public static String[] insertionSort(ArrayList<String> list) {

		String[] array = new String[list.size()];
		array = list.toArray(array);
		System.out.print("\nAfter Sorting: ");
		System.out.print("[");
		for (String s : array) {
			System.out.print(s + ", ");
		}
		System.out.print("]\n");
		String key;
		int i;
		for (int j = 1; j < array.length; j++) {
			key = array[j];
			i = j - 1;
			while (i >= 0) {
				if (key.compareTo(array[i]) > 0) {
					break;
				}
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
		return array;
	}
}