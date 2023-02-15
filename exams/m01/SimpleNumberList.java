package m01;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * Singly-linked list of whole numbers to demonstrate your understanding
 * of linked structures.
 * 
 * @author starter code + Joshua Ashton
 */
public class SimpleNumberList {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of items in the list

	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private int item;
		private Node next;
		
		Node(int item) {
			this.item = item;
		}
	}
	
	/** 
	 * Adds the <code>item</code> at the end of this list.
	 * 
	 * @param item element to be added to the list
	 */
	public void append(int item) {
		Node node = new Node(item);
		
		if (isEmpty()) 
			head = node;
		else 
			tail.next = node;
		tail = node;
		n++;
	}
	
	// = = =   CHALLENGE 1   = = = 
	/** 
	 * Determines how many list elements are a multiple of 11.
	 * If the list is empty, the method should return 0.
	 * 
	 * @return number of elements that are a multiple of 11.
	 */
	public int multiplesOfElevenCount() {	
		if(n == 0)
			return 0;
		
		int count = 0;
		Node current = head;
		while(current != null) {
			if(current.item % 11 == 0)
				count++;
			
			current = current.next;
		}

		return count;
	}
	
	// = = =   CHALLENGE 2   = = = 
	/** 
	 * Determines whether the first and last elements of this lists are even numbers.
	 * If both the first and the last elements are even, the method returns true, 
	 * otherwise it returns false. 
	 * If the list is empty, a NoSuchElementException should be thrown.
	 * 
	 * @return true if the first and the last elements are even and false otherwise.
	 */
	public boolean firstAndLastEven() {	
		if(n == 0)
			throw new NoSuchElementException("The list is empty, unable to access values of elements that do not exist.");
		return (head.item % 2 == 0) && (tail.item % 2 == 0);
	}
	
	/**
	 * Returns the number of items in the list
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * @return true if there are no elements in the list and false otherwise.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/* = = = = = = = = =  Test Client  = = = = = = = = = */	

	// The main method includes a starter code.
	// Add additional test code as needed to provide evidence 
	// that the method works expected.
	
	public static void main(String[] args) {
		StdOut.println("Simple Number List");
		StdOut.println("------------------");
		
		SimpleNumberList list = new SimpleNumberList();
		list.append(22);
		list.append(24);
		list.append(-5);
		list.append(121);
		list.append(3);
		list.append(-11);

		StdOut.println("count: " + list.multiplesOfElevenCount());
		StdOut.println("first and last even: " + list.firstAndLastEven());
		
		// Expected output:
		// Simple Number List
		// ------------------
		// count: 3
		// first and last even: false
	}

}