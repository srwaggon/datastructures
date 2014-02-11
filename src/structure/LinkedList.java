package structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {

  private Node<T> rootNode;

  public LinkedList() {
  }

  @Override
  public boolean add(T item) {
    Node<T> prev = rootNode;

    if (prev == null) {
      rootNode = new Node<T>(item);
      return true;
    }

    Node<T> cursor = rootNode.next;
    while (cursor != null) {
      prev = cursor;
      cursor = cursor.next;
    }
    prev.next = new Node<T>(item);
    return true;
  }

  @Override
  public void add(int index, T item) {

    if (index < 0 || index >= size()) {
      throw new IllegalArgumentException();
    }

    Node<T> cursor = rootNode;
    
    while (index > 0) {
      cursor = cursor.next;
      index--;
    }
    Node<T> holder = new Node<T>(item);
    holder.next = cursor.next;
    cursor.next = holder;
  }

  @Override
  public boolean addAll(Collection<? extends T> arg0) {
    return false;
  }

  @Override
  public boolean addAll(int arg0, Collection<? extends T> arg1) {
    return false;
  }

  @Override
  public void clear() {
    rootNode = null;
  }

  @Override
  public boolean contains(Object arg0) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> arg0) {
    return false;
  }

  @Override
  public T get(int arg0) {
    return null;
  }

  @Override
  public int indexOf(Object arg0) {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return rootNode == null;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public int lastIndexOf(Object arg0) {
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int arg0) {
    return null;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public T remove(int index) {
    Node<T> cursor = rootNode;
    while (index > 0) {

    }
    return null;
  }

  @Override
  public boolean removeAll(Collection<?> arg0) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> arg0) {
    return false;
  }

  @Override
  public T set(int arg0, T arg1) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public List<T> subList(int arg0, int arg1) {
    return null;
  }

  @Override
  public Object[] toArray() {
    return null;
  }

  @Override
  public <T> T[] toArray(T[] arg0) {
    return null;
  }

  class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }

    public T getData() {
      return data;
    }
  }

}
