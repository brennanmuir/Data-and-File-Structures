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
public class ArraySelectionSort {

	/**
	 * @param list
	 * @return
	 */
	public ArrayList<String> selectionSort(ArrayList<String> list) {
		ArrayList<String> internalList = new ArrayList<String>();
		internalList.addAll(list);
		// Locate smallest element from i
	    for(int i = 0; i < internalList.size() - 1; i++) {	
	    	// Record the position of the smallest
	        int iofmin = i;  
	        for(int j = i + 1; j < internalList.size() - 1; j++) {
	        	// Update min if we find a smaller element
	            if(internalList.get(j).compareTo(internalList.get(iofmin))<0) {	
	                iofmin = j;
	            }
	        }
	 
	        // Put the smallest element at position i
	        swap(internalList, i, iofmin);
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
		al.remove(i+1);
		al.add(n, temp);
		al.remove(n+1);
	}
}
