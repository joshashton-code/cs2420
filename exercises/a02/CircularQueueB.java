package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueueB<E> implements Iterable<E> {

	private Node head;
	private Node tail;
	private E item;
	
	private int n;

	public CircularQueueB() {

	}

	  /**
   * Determines if the cicular queue has a number of elements equals to its capacity.
   * 
   * @return true if there are an equal amount of elements to the capacity.
   */
  public boolean isFull() {
		return false; // TODO: Need to implement.
  }

  /**
   * Determines if the queue has any items in it or not.
   * 
   * @return true if there are no items in the queue, otherwise return false.
   */
  public boolean isEmpty() {
		return false; // TODO: Need to implement.
  }

  /**
   * Determines the number of items inside of the queue.
   * 
   * @return the number of items.
   */
  public int size() {
		return -1; // TODO: Need to implement.
  }

  /**
   * Adds item into the cicular queue. Inserts into LinkedList for appropriate positioning.
	 * 
   * @param item
   * @throws UnsupportedOperationException
   */
  public void enqueue(E item) throws UnsupportedOperationException {
    if(isFull())
      throw new UnsupportedOperationException("Cannot add another element to a full queue.");

  }

  /**
   * Retrieves and removes the next item from the queue.
   * 
   * @return the removed item.
   * @throws NoSuchElementException
   */
  public E dequeue() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException("No elements exist, cannot dequeue an element that does not exist.");

		return null; // TODO: Need to implement.
		}

  /**
   * Retrieves the next item from the queue.
   * 
   * @return the next item.
   * @throws NoSuchElementException
   */
  public E peek() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException("No elements exist, cannot peek an element that does not exist.");

		return null; // TODO: Need to implement.
  }
	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private E item;
		private Node next;
    private Node prev;
	}

	@Override
	public String toString() {
		return null; // TODO: Need to implement in part 2.
	}

	@Override
	public Iterator<E> iterator() {
		return null; // TODO Need to implement
	}
}
