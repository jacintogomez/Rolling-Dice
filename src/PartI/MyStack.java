package PartI;
import java.util.ArrayList;


public class MyStack<E> {

	private ArrayList<E> ar;
	
	public MyStack(){
		this.ar=new ArrayList<E>();
	}
	
	public boolean empty() {
		return ar.isEmpty();
	}
	
	public E peek() {
		return ar.get(ar.size()-1);
	}
	
	public E pop() {
		E top=ar.get(ar.size()-1);
		ar.remove(ar.size()-1);
		return top;
	}
	
	public void push(E top) {
		ar.add(top);
	}
	
	public int search(E el) {
		int ind=ar.lastIndexOf(el);
		if(ind==-1) {return -1;}
		else {return ind-1;}
	}
}
