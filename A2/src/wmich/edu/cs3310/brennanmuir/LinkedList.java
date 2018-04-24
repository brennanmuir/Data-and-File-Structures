package wmich.edu.cs3310.brennanmuir;

public class LinkedList<L> {

private Node head = null;

public void insertFirst(L data) {
    Node n = new Node(data);
    n.next = head;
    head = n;
}

public Node deleteFirst() {
    Node temp = head;
    head = head.next;
    return temp;
}

public void displayList() {
    Node current = head;
    while (current != null) {
        current.displayNode();
        current = current.next;
    }
}

public boolean isEmpty() {
    return (head == null);
  }
}