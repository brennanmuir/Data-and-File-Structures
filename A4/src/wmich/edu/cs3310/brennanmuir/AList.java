package wmich.edu.cs3310.brennanmuir;

import java.util.ArrayList;

public class AList {
	
	public void displayArray(ArrayList<String> list){
		System.out.print("[");
		for (String s : list) {
			System.out.print(s + ", "); 
			}
		System.out.print("]");
	}
	
}
