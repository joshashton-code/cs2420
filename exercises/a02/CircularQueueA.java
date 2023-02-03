package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueueA<Item> implements Iterable<Item> {

  private Item[] items;
  private int n;

  public CircularQueueA(int capacity) throws IllegalArgumentException {
    if(capacity < 1)
      throw new IllegalArgumentException();

    items = new Item[capacity];
    n = 0;
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
   * Adds item into the cicular queue. Reuses positions from removed elements.
   * @param item
   * @throws UnsupportedOperationException
   */
  public void enqueue(Item item) throws UnsupportedOperationException {

  }

  /**
   * Retrieves and removes the next item from the queue.
   * 
   * @return the removed item.
   * @throws NoSuchElementException
   */
  public Item dequeue() throws NoSuchElementException {
    return new Item();
  }

  /**
   * Retrieves the next item from the queue.
   * 
   * @return the next item.
   * @throws NoSuchElementException
   */
  public Item peek() throws NoSuchElementException {
    return new Item();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public Iterator<Item> iterator() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
