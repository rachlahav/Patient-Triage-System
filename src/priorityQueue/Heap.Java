//I worked on this project with Silvia Toncelli and KJ Hill
package priorityqueue;

import java.util.Comparator;

import app.Condition;
import app.PatientConditionComparator;

@SuppressWarnings("unchecked")
public class Heap<T> implements PriorityQueueADT<T> {

  private int numElements;
  private T[] heap;
  private boolean isMaxHeap;
  private Comparator<T> comparator;
  private final static int INIT_SIZE = 5;

  /**
   * Constructor for the heap.
   * @param comparator comparator object to define a sorting order for the heap elements.
   * @param isMaxHeap Flag to set if the heap should be a max heap or a min heap.
   */
  public Heap(Comparator<T> comparator, boolean isMaxHeap) {
      //TODO: Implement this method.
      heap = (T[]) new Object[INIT_SIZE];
      this.isMaxHeap = isMaxHeap;
      this.comparator = comparator; 
      numElements = 0;
    }

  /**
   * This results in the entry at the specified index "bubbling up" to a location
   * such that the property of the heap are maintained. This method should run in
   * O(log(size)) time.
   * Note: When enqueue is called, an entry is placed at the next available index in 
   * the array and then this method is called on that index. 
   *
   * @param index the index to bubble up
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleUp(int index) {
      //TODO: Implement this method.
      if (index >= numElements){
        throw new IndexOutOfBoundsException();
      }
      if (index == 0){
        throw new IndexOutOfBoundsException();
      }

      while (index > 0){
        int parentIndex = (index - 1)/2;
        if (compareElements(heap[index],heap[parentIndex]) <= 0){
          return;
        } 
        else {
          swap (heap, index, parentIndex);
          index = parentIndex;
        }
      }
    }
  
  public void swap (Object [] heap, int index, int index2){
      Object temp = heap[index];
      heap[index] = heap[index2];
      heap[index2] = temp;
  }

  /**
   * This method results in the entry at the specified index "bubbling down" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time.
   * Note: When remove is called, if there are elements remaining in this
   *  the bottom most element of the heap is placed at
   * the 0th index and bubbleDown(0) is called.
   * 
   * @param index
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleDown(int index) {

    if(index < 0 || index > numElements){
      throw new IndexOutOfBoundsException();
    }

    int childIndex = (2 * index) + 1;
    T value = heap[index];

    while (childIndex < numElements){
      T maxValue = value;
      int maxIndex = index;

      for (int i = 0; i < 2 && i + childIndex < getSize(); i++){
        if (compareElements(heap[i + childIndex], maxValue) > 0) {
           maxValue = heap[i + childIndex];
          maxIndex = i + childIndex;
        }
      }
      if (maxValue == value){
        return;
      }
      else {
        swap(heap, index, maxIndex);
        index = maxIndex;
        childIndex = (2 * index) + 1;
      }
    }
  }

  /**
   * Test for if the queue is empty.
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    if (getSize() == 0){
      return true;
    } 
    else {
      return false;
    }
  }

  /**
   * Number of data elements in the queue.
   * @return the size
   */
  public int getSize(){
    return numElements;
  }

  /**
   * Compare method to implement max/min heap behavior. It changes the value of a variable, compareSign, 
   * based on the state of the boolean variable isMaxHeap. It then calls the compare method from the 
   * comparator object and multiplies its output by compareSign.
   * @param element1 first element to be compared
   * @param element2 second element to be compared
   * @return positive int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * negative int otherwise (if isMaxHeap),
   * return negative int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * positive int otherwise (if ! isMinHeap).
   */
  public int compareElements(T element1 , T element2) {
    int result = 0;
    int compareSign =  -1;
    if (isMaxHeap) {
      compareSign = 1;
    }
    result = compareSign * comparator.compare(element1, element2);
    return result;
  }

  /**
   * Return the element with highest (or lowest if min heap) priority in the heap 
   * without removing the element.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T peek() throws QueueUnderflowException {
    T data = null;
      if (isEmpty()){
        throw new QueueUnderflowException();
      } else if (heap[0] != null) {
        data = heap[0];
      }
      return data;
  }  

  /**
   * Removes and returns the element with highest (or lowest if min heap) priority in the heap.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T dequeueElement() throws QueueUnderflowException{
    T data;
      if (isEmpty()){
        throw new QueueUnderflowException();
      }
      data = heap[0];
      heap[0] = null;
    
      for (int i = 1; i <= numElements; i++){
        if (heap[i] == null)
          break;
        heap [i - 1] = heap [i];
      }

      numElements--;
      bubbleDown(0);
      T maxValue = heap[0];
      int maxIndex = 0;

      for (int i = 0; i < getSize(); i++){
        if (getSize() == 1){
          break;
        }
        if (compareElements(heap[i], maxValue) > 0){
        maxIndex = i;
        }

      if (maxIndex != 0){
        bubbleUp(maxIndex);
      }
    }
    return data;
  }


  /**
   * Enqueue the element.
   * @param the new element
   */
  public void enqueueElement(T newElement) {
      //TODO: Implement this method.

      if (newElement == null){
        throw new NullPointerException();
      }
      numElements++;
      if (numElements - 1 < heap.length){
        heap[numElements-1] = newElement;  
      }
      else {
        expandCapacity();
        heap[numElements-1] = newElement;
      }
      if (numElements > 1)
        bubbleUp(numElements-1);
    }

  private void expandCapacity(){
    T [] newHeap = (T[]) new Object[heap.length * 2];
    for (int i = 0; i < numElements - 1; i++){
        newHeap[i] = heap[i];
    }
    heap = newHeap;
  }
}