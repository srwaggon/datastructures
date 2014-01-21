package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<T> implements List<T> {

  protected Object[] elements;
  private int size;
  
  public ArrayList() {
    elements = new Object[2];
  }

  @Override
  public boolean add(T e) {
    expandIfTooSmall();
    elements[size++] = e;
    return true;
  }

  private void expand() {
    Object[] expandedElements = new Object[size() * 2];
    for (int i = 0; i < size(); i++) {
      expandedElements[i] = elements[i];
    }
    elements = expandedElements;
  }

  @Override
  public void add(int index, T element) {
    thowExceptionIfOutOfRange(index);
    expandIfTooSmall();
    for (int i = size(); i > index; i--) {
      elements[i] = elements[i - 1];
    }
    elements[index] = element;
  }

  private void thowExceptionIfOutOfRange(int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void expandIfTooSmall() {
    if (size >= elements.length) {
      expand();
    }
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    Iterator<? extends T> iterator = c.iterator();
    while (iterator.hasNext()) {
      T item = iterator.next();
      add(item);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    return false;
  }

  @Override
  public void clear() {
    size = 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    return null;
  }

  @Override
  public boolean remove(Object o) {
    int index = find(o);

    if (index == -1) {
      return false;
    }

    remove(index);

    return true;
  }

  private int find(Object o) {
    for (int i = 0; i < size(); i++) {
      if (elements[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public T remove(int index) {

    thowExceptionIfOutOfRange(index);

    Object removed = elements[index];

    for (int i = index; i < size() - 1; i++) {
      elements[i] = elements[i + 1];
    }
    size--;
    return (T) removed;
  }

  @Override
  public boolean removeAll(Collection<?> c) {

    boolean changed = false;

    Iterator<?> iterator = (Iterator<?>) c.iterator();
    
    while(iterator.hasNext()) {
      Object item = iterator.next();
      changed = changed || remove(item);
    }

    return changed;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public T set(int index, T element) {
    Object elem = elements[index];
    elements[index] = element;
    return (T) elem;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return null;
  }

  @Override
  public Object[] toArray() {
    return elements;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return (T[]) elements;
  }

}
