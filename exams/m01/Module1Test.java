package m01;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * CSIS 2420 Midterm1 coding challenge.
 * 
 * @author starter code + Joshua Ashton
 *
 */
public class Module1Test {
	
	// = = = =   CHALLENGE 3   = = = = 
	/**
	 * Creates an Iterable<Character> that includes the elements from 
	 * <code>queue</code> with the following modifications</p>
	 * 
	 * <ol type = "A">
	 * <li>Replace lower-case letters with upper-case letters.</li>
	 * <li>Remove all numbers.
	 *     (Those are the characters '0', '1', .. '9')
	 * <li>Add an asterisk ('*') to the beginning and end of the Iterable<Character> </li>
	 * <li>Reverse the order of the <code>queue</code> elements. </li>
	 * <li>Corner cases: <br />
	 * If <code>queue</code> is empty, an empty Iterable<Character> should be returned <br />
	 * If <code>queue</code> is null, null should be returned. (No exception should be thrown)</li>
	 * </ol>
	 * 
	 * @param queue
	 * @return the Iterable<Character> sequence of characters based on the queue and the modifications.
	 */
	public static Iterable<Character> challenge3(Queue<Character> queue) {	
		if(queue == null)
			return null;
		if(queue.size() == 0)
			return new Queue<Character>();

		Stack<Character> q = new Stack<>();
		q.push('*');
		for (Character c : queue) {
			if(!c.isDigit(c))
				q.push(c.toUpperCase(c));
		}	
		q.push('*');

		return q; 
	}

	/* = = = = = = = = = Test Client = = = = = = = = = */

	// The main method includes a starter code.
	// Add additional test code as needed to provide evidence 
	// that the method works expected.
	
	public static void main(String[] args) {
		StdOut.println("Challenge 3");
		StdOut.println("-----------");
		
		Queue<Character> queue = new Queue<>();
		queue.enqueue('g');
		queue.enqueue('0');
		queue.enqueue('0');
		queue.enqueue('d');
		queue.enqueue(' ');
		queue.enqueue('L');
		queue.enqueue('u');
		queue.enqueue('C');			
		queue.enqueue('k');
		queue.enqueue('!');		 
		
		StdOut.println(queue + "=> " + challenge3(queue)); 
		
		// expected output: 
		// Challenge 3
		// -----------
		// g 0 0 d   L u C k ! => * ! K C U L   D G * 
		
	}

}
