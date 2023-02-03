package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueueA<E> implements Iterable<E> {

  private E[] items;
  private int n;

  public CircularQueueA(int capacity) throws IllegalArgumentException {
    if(capacity < 1)
      throw new IllegalArgumentException("Cannot create a queue with a capacity lower than 1. Capacity higher than 2 is recommended.");

    items = new Item[capacity];
    n = 0;
  }

  /**
   * Determines if the cicular queue has a number of elements equals to its capacity.
   * 
   * @return true if there are an equal amount of elements to the capacity.
   */
  public boolean isFull() {
    return size() == items.length;
  }

  /**
   * Determines if the queue has any items in it or not.
   * 
   * @return true if there are no items in the queue, otherwise return false.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Determines the number of items inside of the queue.
   * 
   * @return the number of items.
   */
  public int size() {
    int counter = 0;
    for (int i = 0; i < items.length; i++) {
      if(items[i] != null)
        counter++;
    }

    return counter;
  }

  /**
   * Adds item into the cicular queue. Reuses positions from removed elements.
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

    return new E();
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

    return new E();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
