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
public class ArrayBubbleSort {

	/**
	 * @param list
	 * @return
	 */
	public ArrayList<String> bubbleSort(ArrayList<String> list) {
		ArrayList<String> internalList = new ArrayList<String>();
		internalList.addAll(list);
		for (int i = internalList.size() - 1; i >= 0; i--) {
			for (int n = 0; n < i - 1; n++) {
				if (internalList.get(n).compareTo(internalList.get(n + 1)) > 0) {
					swap(internalList, n, n + 1);
				}
			}
		}
		return internalList;
	}

	/**
	 * @param al
	 * @param i
	 * @param n
	 */
	public void swap(ArrayList<String> al, int i, int n) {
		String temp = al.get(i);
		al.add(i, al.get(n));
		al.remove(i + 1);
		al.add(n, temp);
		al.remove(n + 1);
	}
}
