package wmich.edu.cs3310.brennanmuir;

//Brennan Muir
//CS3310
//A4
//11/13/16

import java.io.*;
import java.util.*;
import java.util.ArrayList;

/**
 * @author brennanmuir
 *
 */
public class Driver {

	public static long start, end;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// Read in file, set scanners, linkedList, and arrayList objects
		File file = new File("NameList.txt");
		Scanner scan = new Scanner(file);
		Scanner aScan = new Scanner(file);
		Scanner originalScan = new Scanner(file);
		AList ArrayList = new AList();
		LinkedList<String> ll = new LinkedList<String>();

		String data;
		// Fill linked list
		while (scan.hasNextLine()) {
			data = scan.nextLine();
			ll.add(data);
		}

		// Fill the file into an Array List
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> originalList = new ArrayList<String>();
		while (aScan.hasNext()) {
			list.add(aScan.next());
		}
		scan.close();
		while (originalScan.hasNext()) {
			originalList.add(originalScan.next());
		}
		originalScan.close();

		// Display LinkedList
		System.out.println("DISPLAY UNSORTED LINKED LIST");
		System.out.println(ll);

		startTimer();
		System.out.println("\nDISPLAY BUBBLE SORTED LINKED LIST");
		LinkedBubbleSort lbs = new LinkedBubbleSort(ll);
		endTimer();

		startTimer();
		System.out.println("\nDISPLAY SELECTION SORTED LINKED LIST");
		LinkedSelectionSort lss = new LinkedSelectionSort(ll);
		endTimer();

		startTimer();
		System.out.println("\nDISPLAY MERGE SORTED LINKED LIST");
		Comparable[] array = list.toArray(new Comparable[list.size()]);
		LinkedMergeSort lms = new LinkedMergeSort(array);
		endTimer();

		startTimer();
		System.out.print("\nDISPLAY INSERTION SORTED LINKED LIST");
		String[] linkedArray = list.toArray(new String[list.size()]);
		LinkedInsertionSort lis = new LinkedInsertionSort();
		lis.insertionSort(linkedArray);
		endTimer();

		// Display ArrayList
		System.out.println("\n\n\n\nDISPLAY UNSORTED ARRAY LIST");
		ArrayList.displayArray(list);

		startTimer();
		System.out.println("\n\nDISPLAY BUBBLE SORTED ARRAY LIST");
		ArrayBubbleSort abs = new ArrayBubbleSort();
		System.out.print("Before sorting: ");
		ArrayList.displayArray(list);
		System.out.print("\nAfter Sorting: ");
		ArrayList.displayArray(abs.bubbleSort(list));
		System.out.print("\n");
		endTimer();

		startTimer();
		System.out.println("\nDISPLAY SELECTION SORTED ARRAY LIST");
		ArraySelectionSort ass = new ArraySelectionSort();
		System.out.print("Before Sorting: ");
		ArrayList.displayArray(list);
		System.out.print("\nAfter Sorting: ");
		ArrayList.displayArray(ass.selectionSort(list));
		System.out.print("\n");
		endTimer();

		startTimer();
		System.out.print("\nDISPLAY MERGE SORTED ARRAY LIST");
		System.out.print("\nBefore Sorting: ");
		ArrayList.displayArray(list);
		ArrayMergeSort ams = new ArrayMergeSort();
		System.out.print("\nAfter Sorting: ");
		ArrayList.displayArray(ams.mergeSort(list));
		System.out.print("\n");
		endTimer();

		startTimer();
		System.out.println("\nDISPLAY INSERTION SORTED ARRAY LIST");
		ArrayInsertionSort ais = new ArrayInsertionSort();
		System.out.print("Before Sorting: ");
		ArrayList.displayArray(originalList);
		ais.insertionSort(list);
		endTimer();

	}

	// Timers for calculating time complexity
	public static void startTimer() {
		start = System.nanoTime();
	}

	public static void endTimer() {
		end = System.nanoTime();
		System.out.println("Processing time is " + (end - start) / 1000.0 + " us.\n");
	}

}
