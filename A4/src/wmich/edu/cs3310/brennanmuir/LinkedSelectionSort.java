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
public class LinkedSelectionSort {

	public LinkedSelectionSort(LinkedList input) {
		List list = new List();

		for (int i = input.size() - 1; i >= 0; i--) {
			list.addtoList((String) input.get(i));
		}

		System.out.print("Before Sorting: [");
		list.print();
		list.selectionSort();
		System.out.print("After Sorting: [");
		list.print();
	}

	class Node {
		public String value;
		public Node next;

		/**
		 * method to create new node with given data
		 * 
		 * @param data
		 */
		public Node(String data) {
			value = data;
		}
	}

	/**
	 * @author brennanmuir
	 *
	 */
	class List {

		private int length;
		private Node head;
		private Node tail;

		/**
		 * method to add a new node to the list with given data
		 * 
		 * @param data
		 */
		public void addtoList(String data) {
			Node node = new Node(data);
			if (length == 0) {
				node.next = null;

			} else {
				node.next = head;
			}
			head = node;
			length++;
		}

		
		public void print() {
			Node node = head;
			while (node != null) {
				System.out.print(node.value + ", ");
				node = node.next;
			}
			System.out.println("]");
		}


		public void selectionSort() {
			for (Node node1 = head; node1 != null; node1 = node1.next) {
				Node min = node1;
				for (Node node2 = node1; node2 != null; node2 = node2.next) {

					if (min.value.compareTo(node2.value) > 0) {
						min = node2;
					}
				}

				Node temp = new Node(node1.value);
				node1.value = min.value;
				min.value = temp.value;
			}
		}
	}
}