package wmich.edu.cs3310.brennanmuir;

//Brennan Muir
//CS3310
//A4
//11/13/16

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author brennanmuir
 *
 */
class LinkedBubbleSort {

	/**
	 * constructor used to pass data into this class
	 * 
	 * @param input
	 */
	public LinkedBubbleSort(LinkedList input) {
		ListIterator<String> listIterator = input.listIterator();
		LinkedBubbleSort lbs = new LinkedBubbleSort();

		// Add all the elements to the linked-list
		while (listIterator.hasNext()) {
			lbs.add(listIterator.next());
		}

		System.out.print("Before Sorting: ");
		lbs.print();
		lbs.sort();
		System.out.print("After Sorting: ");
		lbs.print();
	}

	public static class Node {
		String data;
		Node nextNode;

		/**
		 * method to create a node with given data
		 * 
		 * @param data
		 */
		public Node(String data) {
			this.data = data;
			this.nextNode = null;
		}

		/**
		 * method to get the node data
		 * 
		 * @return
		 */
		public String getData() {
			return this.data;
		}
	}

	private Node head;
	private int size;

	public LinkedBubbleSort() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * 
	 * 
	 * @param data
	 */
	public void add(String data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node currentNode = head;
			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
			}
			currentNode.nextNode = node;
		}
		size++;
	}

	public void sort() {
		if (size > 1) {
			boolean wasChanged;

			do {
				Node current = head;
				Node previous = null;
				Node next = head.nextNode;
				wasChanged = false;

				// Loop while there's still data
				while (next != null) {
					// Test for out of order elements
					if (current.data.compareTo(next.data) > 0) {
						wasChanged = true;

						if (previous != null) {
							Node sig = next.nextNode;
							previous.nextNode = next;
							next.nextNode = current;
							current.nextNode = sig;
						} else {
							Node sig = next.nextNode;
							head = next;
							next.nextNode = current;
							current.nextNode = sig;
						}

						previous = next;
						next = current.nextNode;
					} else {
						previous = current;
						current = next;
						next = next.nextNode;
					}
				}
			} while (wasChanged);
		}
	}


	public void print() {
		Node currentNode = head;

		System.out.print("[");
		while (currentNode != null) {
			String data = currentNode.getData();
			System.out.print(data + ", ");
			currentNode = currentNode.nextNode;
		}

		System.out.print("]");
		System.out.println();
	}

}
