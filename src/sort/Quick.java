package sort;

import java.util.List;

public class Quick {

  public static <T extends Comparable> void sort(List<T> data) {
    sort(data, 0, data.size() - 1);
  }

  private static <T extends Comparable> void sort(List<T> data, int leftIndex,
      int rightIndex) {

    System.out.println("Sorting... " + data.subList(leftIndex, rightIndex + 1));

    if (leftIndex < rightIndex) {

      int partitionIndex = partition(data, leftIndex, rightIndex);

      sort(data, leftIndex, partitionIndex - 1);
      sort(data, partitionIndex + 1, rightIndex);
    }

  }

  protected static <T extends Comparable> int partition(List<T> data,
      int leftIndex, int rightIndex) {

    int pivotIndex = getPivotIndex(leftIndex, rightIndex);
    T pivotValue = data.get(pivotIndex);

    swap(data, pivotIndex, rightIndex);

    int storeIndex = leftIndex;

    for (int i = leftIndex; i < rightIndex; i++) {
      if (comesBefore(data.get(i), pivotValue)) {
        swap(data, storeIndex, i);
        storeIndex++;
      }
    }

    swap(data, rightIndex, storeIndex);

    return storeIndex;
  }

  private static int getPivotIndex(int leftIndex, int rightIndex) {
    return ((int) Math.random() * (rightIndex - leftIndex)) + leftIndex;
  }

  protected static <T extends Comparable> boolean comesBefore(T elm1, T elm2) {
    return elm1.compareTo(elm2) <= 0;
  }

  public static <T extends Comparable> void swap(List<T> data, int i, int j) {
    T held = data.get(j);
    data.set(j, data.get(i));
    data.set(i, held);
    return;
  }

}
