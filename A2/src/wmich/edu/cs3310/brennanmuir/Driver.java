package wmich.edu.cs3310.brennanmuir;

import java.io.*;
import java.util.*;

//Brennan Muir
//CS3310
//A2
//10/18/16

public class Driver {

	public static void main(String[] args) throws IOException {
		Stacks s1 = new Stacks();
		Stacks s2 = new Stacks();
		Queues q = new Queues();
		LinkedList l = new LinkedList();
		
		//Read in data from a text file, fill into an array.
		Scanner reader = new Scanner(new File("TestForStackAndQueue.txt"));
		List<String> lines = new ArrayList<String>();
		while (reader.hasNextLine()) {
		  lines.add(reader.nextLine());
		}

		String[] data = lines.toArray(new String[0]);
		
		
		
		//Starting Stack
		System.out.println("Implemented stack using linked-lists and performing push() & pop()");
	    
	    //Push and pop commands
	    s1.push(data[0]);
	    s1.push("Hello");
	    s1.push(data[1]);
	    s1.push(data[2]);
	    //Display current stack
	    System.out.print("\nPush 'first object', 'Hello'. 'second object', '3':");
	    s1.displayStack();
	    
	    s1.pop();
	    //Display current stack
	    s1.displayStack();
	    
	    s1.pop();
	    s1.push(data[3]);
	    
	    s1.pop();
	    s1.pop();
	    //Display current stack
	    s1.displayStack();
	    s1.pop();
	    s1.push(data[4]);
	    //Display current stack
	    s1.displayStack();
	    s1.pop();
	    s1.pop(); //Stack is cleared
	    //Now going to use 2 stacks, to create a queue
	    
	    s1.push(1);
	    s1.push(2);
	    s1.push(3);
	    s2.push(s1.pop2());
	    s2.displayStack();
	    
	    System.out.println("\n\nImplemented queue using linked-lists and performing add() & delete()");
	    q.add(1);
	    q.add(2);
	    q.add(3);
	    q.delete(); //Remove first in queue
	    q.add(1); //Add to end of queue
	    q.add(data[1]);
	    q.add(1);
        
	    while (!q.isEmpty()) {
            System.out.println(q.delete());
        }
	    
	    minValue();
	    //Time to design and implement a strategy of using two stacks to implement the functionality of a queue
	}
	
	
	public static void minValue() throws FileNotFoundException{
		Scanner file = new Scanner(new File("TestForMinVlue.txt"));
		Stacks min = new Stacks();
		Stacks stack = new Stacks();
		
		System.out.println("\n\n\nFinding MinValue of a stack");
		
		int [] temp = new int[20];
		
		int minInt = file.nextInt();
		System.out.print(file.next() + "\t");
		stack.push(file.next());
		stack.push(minInt);
		int i = 0;
		while (file.hasNextInt()){
			temp[i] = file.nextInt();
			stack.push(temp[i]);
			System.out.print(temp[i]+" ");
			if(temp[i] >= minInt){
				min.push(minInt);
			}
			else{
				minInt = temp[i];
				min.push(minInt);
			}
			i++;
		}
		System.out.print("\n");
		System.out.print("The minimum of this stack is the first digit listed below, ignore any that may follow");
		min.displayStack();
	}
}
