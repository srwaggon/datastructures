package sort;

import java.util.List;

public class Bubble {


  public static void sort(List<? extends Comparable> data) {

    boolean changed = true;

    while (changed) {
      changed = false;
      for (int i = 0; i < data.size() - 1; i++) {

        final Comparable next = data.get(i + 1);
        final Comparable now = data.get(i);

        if (!inOrder(now, next)) {
          swap(data, i, i + 1);
          changed = true;
        }
      }
    }
  }

  protected static <T extends Comparable> boolean inOrder(T elm1, T elm2) {
    return elm1.compareTo(elm2) < 0;
  }

  public static <T extends Comparable> void swap(List<T> data, int i, int j) {
    T held = data.get(j);
    data.set(j, data.get(i));
    data.set(i, held);
    return;
  }
}
