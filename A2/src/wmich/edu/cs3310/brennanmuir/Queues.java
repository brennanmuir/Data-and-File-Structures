package wmich.edu.cs3310.brennanmuir;

import java.util.NoSuchElementException;

public class Queues<Q> {
	private Node<Q> front;
	private Node<Q> rear;
	private int size;


    private static class Node<Q> {
        Q item;
        Node<Q> next;

        Node (Q item, Node<Q> next) {
            this.item = item;
            this.next = next;
        }
    }

    Node<Q> createNode(Q item) {
        return new Node<Q>(item, null);
    }

    public void add(Q item) {
        Node<Q> node = createNode(item);
        add(node);
    }

    void add(Node<Q> node) {
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }

        rear = node;
        size++;
    }

    public Q delete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Q item = front.item;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }
        return item;
    }

    public Q peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.item;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }


}









