package sort;

import java.util.ArrayList;
import java.util.List;

public class Merge {

  public static <T extends Comparable> List<T> sort(List<T> data) {
    return mergeSplit(data);
  }

  protected static <T extends Comparable> List<T> mergeSplit(List<T> data) {

    if (data.size() < 2) {
      return data;

    } else {

      int runLength = data.size() / 2;
      List<T> left = mergeSplit(data.subList(0, runLength));
      List<T> right = mergeSplit(data.subList(runLength, data.size()));

      return merge(left, right);
    }

  }

  protected static <T extends Comparable> List<T> merge(List<T> left,
      List<T> right) {

    List<T> result = new ArrayList<T>();

    int i = 0, j = 0;
    while (i < left.size() || j < right.size()) {
      
      if (i >= left.size()) {
        result.add(right.get(j++));
      } else if (j >= right.size()) {
        result.add(left.get(i++));
      } else {

      final T next = comesBefore(left.get(0), right.get(0)) ? left.get(i++)
          : right.get(j++);

      result.add(next);
      }
    }
    return result;
  }

  protected static <T extends Comparable> boolean comesBefore(T elm1, T elm2) {
    return elm1.compareTo(elm2) <= 0;
  }
}
