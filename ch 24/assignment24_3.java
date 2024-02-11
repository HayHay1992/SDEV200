import java.util.Iterator;

public class assignment24_3 {

 public static void main(String[] args) {
  MyLinkedList<String> list = new MyLinkedList<>();
  }
  System.out.println(list);
 }

}

class MyLinkedList<E> extends MyAbstractList<E> {
 private Node<E> head, tail;

 /** Create default list */
 public MyLinkedList() {
 }

 /** Create list from array of objects */
 public MyLinkedList(E[] objects) {
  super(objects);
 }

 /** Return head element in list */
 public E getFirst() {
  if (size == 0) {
   return null;
  } else {
   return head.element;
  }
 }

 /** Return last element in list */
 public E getLast() {
  if (size == 0) {
   return null;
  } else {
   return tail.element;
  }
 }

 /** Add element to beginning of list */
 public void addFirst(E e) {
  Node<E> newNode = new Node<E>(e); 
  newNode.next = head; 
  newNode.previous = null;
  head = newNode; 
  size++; 

  if (tail == null) 
   tail = head;
 }

 /** Add element to end of list */
 public void addLast(E e) {
  Node<E> newNode = new Node<E>(e);

  if (tail == null) {
   head = tail = newNode;
  } else {
   tail.next = newNode;
   newNode.previous = tail;
   newNode.next = null;
   tail = tail.next; 
  }
 }

 @Override
 /** Add new element at the specified index 
  * in this list. The index of head element is 0 */
 public void add(int index, E e) {
  if (index == 0) {
   addFirst(e);
  } else if (index >= size) {
   addLast(e);
  } else {
   Node<E> current = head;
   for (int i = 1; i < index; i++) {
    current = current.next;
   }
   Node<E> temp = current.next;
   current.next = new Node<E>(e);
   (current.next).previous = current;
   (current.next).next = temp;
   size++;
  }
 }

 /**
  * Remove head node and return object that is contained in
  * removed node.
  */
 public E removeFirst() {
  if (size == 0) {
   return null;
  } else {
   Node<E> temp = head;
   head = head.next;
   size--;
   if (head == null) {
    tail = null;
   } else {
    head.previous = null;
   }
   return temp.element;
  }
 }

 /**
  * Remove last node and return object that is contained in
  * removed node.
  */
 public E removeLast() {
  if (size == 0) {
   return null;
  } else if (size == 1) {
   Node<E> temp = head;
   head = tail = null;
   size = 0;
   return temp.element;
  } else {
   Node<E> temp = tail;
   tail = tail.previous;
   tail.next = null;
   size--;
   return temp.element;
  }
 }

 @Override
 /** Remove element at specified position in
  *  list. Return element that was removed from list. */
 public E remove(int index) {
  if (index < 0 || index >= size) {
   return null;
  } else if (index == 0) {
   return removeFirst();
  } else if (index == size - 1) {
   return removeLast();
  } else {
   Node<E> previous = head;

   for (int i = 1; i < index; i++) {
    previous = previous.next;
   }

   Node<E> current = previous.next;
   previous.next = current.next;
   previous.next.previous = previous;
   size--;
   return current.element;
  }
 }

 @Override
 /** Override toString() to return elements in list */
 public String toString() {
  StringBuilder result = new StringBuilder("[");

  Node<E> current = head;
  for (int i = 0; i < size; i++) {
   result.append(current.element);
   current = current.next;
   if (current != null) {
    result.append(", ");
   } else {
    result.append("]"); 
   }
  }

  return result.toString();
 }

 @Override
 /** Clear list */
 public void clear() {
  size = 0;
  head = tail = null;
 }

 @Override
 /** Return true if list contains element e */
 public boolean contains(E e) {
  if(size == 0) {
   return false;
  } else {
   Node<E> tmp = head;
   while(tmp != null) {
    if(tmp.element.equals(e)) {
     return true;
    } else {
     tmp = tmp.next;
    }
   }
  }
  return false;
 }

 @Override
 /** Return element at specified index */
 public E get(int index) {
  checkIndex(index);
  Node<E> result = head;
  for (int i = 0; i < index; i++) {
   result = result.next;
  }
  return result.element;
 }

 @Override
 /** Return index of head matching element in 
  *  list. Return -1 if no match. */
 public int indexOf(E e) {
  if(size == 0) {
   return -1;
  } else {
   Node<E> tmp = head;
   int result = 0;
   while(tmp != null) {
    if(tmp.element.equals(e)) {
     return result;
    } else {
     tmp = tmp.next;
     result++;
    }
   }
  }
  return -1;
 }

 @Override
 /** Return index of last matching element in 
  *  this list. Return -1 if no match. */
 public int lastIndexOf(E e) {
  if(size == 0) {
   return -1;
  } else {
   Node<E> tmp = tail;
   int result = size - 1;
   while(tmp != null) {
    if(tmp.element.equals(e)) {
     return result;
    } else {
     tmp = tmp.previous;
     result--;
    }
   }
  }
  return -1;
 }

 @Override
 /** Replace element at specified position 
  *  in list with specified element. */
 public E set(int index, E e) {
  checkIndex(index);
  Node<E> tmp = head;
  for (int i = 0; i < index; i++) {
   tmp = tmp.next;
  }
  tmp.element = e;
  return e;
 }

 @Override
 /** Override iterator() defined in Iterable */
 public java.util.Iterator<E> iterator() {
  return new LinkedListIterator();
 }

 private void checkIndex(int index) {
  if (index < 0 || index >= size)
   throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
     + size);
 }

 private class LinkedListIterator implements java.util.Iterator<E> {
  private Node<E> current = head; // Current index

  @Override
  public boolean hasNext() {
   return (current != null);
  }

  @Override
  public E next() {
   E e = current.element;
   current = current.next;
   return e;
  }

  @Override
  public void remove() {
   if(current != null) {
    Node<E> tmp = current;
    current = current.next;
    size--;
    if(tmp.next != null)
     tmp.next.previous = tmp.previous;
    if(tmp.previous != null)
     tmp.previous.next = tmp.next;
   }
   
  }
 }

 private static class Node<E> {
  E element;
  Node<E> next;
  Node<E> previous;

  public Node(E e) {
   element = e;
  }
 }
}
