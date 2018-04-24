package wmich.edu.cs3310.brennanmuir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	public static String name, action, course, grade, data, data2;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner reader = new Scanner(new File("datafile"));
		String[] list;

		ArrayList<String> existingData = new ArrayList<String>();

		BinarySearchTree<String> bst = new BinarySearchTree<String>();

		while (reader.hasNextLine()) {

			list = reader.nextLine().split(":|,");
			action = list[0];

			if (list.length == 2) {
				name = (list[1].trim());
			} else if (list.length == 3) {
				name = (list[1] + " " + list[2]).trim();
			} else if (list.length > 3) {
				name = (list[1] + " " + list[2]).trim();
				course = list[3].trim();
				grade = list[4].trim();
			}
			data = (name + " " + course + " " + grade);
			data2 = (name + " " + course + " " + grade);

			switch (action) {
			case "Insert":

				existingData.add(data);

				System.out.println("\nINSERT: " + data);

				bst.insert(name);
				break;
			// ***********************************************************************************************
			case "Delete":
				name = (list[1] + " " + list[2]).trim();
				System.out.println("\nDELETE: " + name);

				bst.delete(name);

				break;
			// ***********************************************************************************************
			case "Search":
				if (list.length > 2) {
					name = (list[1] + " " + list[2]).trim();
					System.out.println("\nSEARCH: " + name);

					System.out.println(bst.search(name));
				}
				break;
			// ***********************************************************************************************
			case "Inorder":

				System.out.println("\n*******************INORDER********************");
				bst.inOrder();
				System.out.println();

				break;
			// ***********************************************************************************************
			case "Preorder":

				System.out.println("\n*******************PREORDER*******************");
				bst.preOrder();
				System.out.println();

				break;
			// ***********************************************************************************************
			case "Postorder":

				System.out.println("\n*******************POSTORDER******************");
				bst.postOrder();
				System.out.println();
				break;
			default:
				System.out.println("\n" + list[0] + "\n");
				break;
			}
		}
		System.out.println();
	}

	private Node<T> root;
	private Comparator<T> comparator;

	public BinarySearchTree() {
		root = null;
		comparator = null;
	}

	public BinarySearchTree(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

	private int compare(T x, T y) {
		if (comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}
	
	// ******************************************NODE*****************************************************

		private class Node<T> {
			private T data;
			private Node<T> left, right;

			public Node(T data, Node<T> l, Node<T> r) {
				left = l;
				right = r;
				this.data = data;
			}

			public Node(T data) {
				this(data, null, null);
			}

			public String toString() {
				return data.toString();
			}
		}

	// ******************************************INSERT*****************************************************
	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> p, T toInsert) {
		if (p == null)
			return new Node<T>(toInsert);

		if (compare(toInsert, p.data) == 0)
			return p;

		if (compare(toInsert, p.data) < 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	// ******************************************SEARCH*****************************************************
	public boolean search(T toSearch) {
		return search(root, toSearch);
	}

	private boolean search(Node<T> p, T toSearch) {
		if (p == null)
			return false;
		else if (compare(toSearch, p.data) == 0)
			return true;
		else if (compare(toSearch, p.data) < 0)
			return search(p.left, toSearch);
		else
			return search(p.right, toSearch);
	}

	// ******************************************DELETE*****************************************************

	public void delete(T delete) {
		root = delete(root, delete);
	}

	private Node<T> delete(Node<T> p, T delete) {
		if (p == null)
			System.out.println("DOES NOT CONTAIN THIS NAME");
		else if (compare(delete, p.data) < 0)
			p.left = delete(p.left, delete);
		else if (compare(delete, p.data) > 0)
			p.right = delete(p.right, delete);
		else {
			if (p.left == null)
				return p.right;
			else if (p.right == null)
				return p.left;
			else {
				p.data = retrieveData(p.left);
				p.left = delete(p.left, p.data);
			}
		}
		return p;
	}

	private T retrieveData(Node<T> p) {
		while (p.right != null)
			p = p.right;

		return p.data;
	}

	// ******************************************PRE IN AND POST ORDER*****************************************************

	public void preOrder() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node r) {
		if (r != null) {
			System.out.print("\n" + r + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
		}
	}

	public void inOrder() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node r) {
		if (r != null) {
			inOrderHelper(r.left);
			System.out.print("\n" + r + " ");
			inOrderHelper(r.right);
		}
	}

	private void postOrder() {
		postOrderHelper(root);
	}

	private void postOrderHelper(Node r) {
		if (r != null) {
			postOrderHelper(r.left);
			postOrderHelper(r.right);

			System.out.print("\n" + r + " ");
		}

	}

	// ******************************************ITERATOR*****************************************************

	public Iterator<T> iterator() {
		return new Iterate();
	}

	private class Iterate implements Iterator<T> {
		Stack<Node<T>> stk = new Stack<Node<T>>();

		public Iterate() {
			if (root != null)
				stk.push(root);
		}

		public boolean hasNext() {
			return !stk.isEmpty();
		}

		public T next() {
			Node<T> cur = stk.peek();
			if (cur.left != null) {
				stk.push(cur.left);
			} else {
				Node<T> tmp = stk.pop();
				while (tmp.right == null) {
					if (stk.isEmpty())
						return cur.data;
					tmp = stk.pop();
				}
				stk.push(tmp.right);
			}

			return cur.data;
			}

		public void remove() {

		}
	}

}
