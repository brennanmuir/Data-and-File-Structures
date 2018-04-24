package wmich.edu.cs3310.brennanmuir;

import java.util.NoSuchElementException;

public class Stacks<S> {
	private Node head;
	
LinkedList li = new LinkedList();

public void push(Object data) {
    li.insertFirst(data);
}

public void pop() {
    if(!li.isEmpty()){
    li.deleteFirst();
    }
    
    
}

public Object pop2(){
	if(!li.isEmpty()){
		Object temp = li.deleteFirst();
		return temp;
	    }else{
	    	return null;
	    }
}

public void displayStack() {
    System.out.println("  ");
    li.displayList();
  }

}

