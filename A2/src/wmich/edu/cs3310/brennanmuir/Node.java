package wmich.edu.cs3310.brennanmuir;

public class Node<S> {

public Object data;
public Node next;

public Node(S data) {
    this.data = data;
}

public void displayNode() {
    System.out.println(data);
 }
}