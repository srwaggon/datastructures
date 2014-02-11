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

    while (left.size() > 0 || right.size() > 0) {
      result.add(nextAndRemove(left, right));
    }
    return result;
  }

  public static <T extends Comparable> T nextAndRemove(List<T> left,
      List<T> right) {

    if (left.size() <= 0) {
      return right.remove(0);
    }

    if (right.size() <= 0) {
      return left.remove(0);
    }

    return comesBefore(left.get(0), right.get(0)) ? left.remove(0) : right
        .remove(0);
  }

  protected static <T extends Comparable> boolean comesBefore(T elm1, T elm2) {
    return elm1.compareTo(elm2) <= 0;
  }
}
