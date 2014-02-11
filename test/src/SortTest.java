import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import sort.Merge;

public class SortTest {

  ArrayList<Integer> data = new ArrayList<Integer>();

  @Before
  public void setup() {
    data.addAll(Arrays.asList(new Integer[] { 2, 3, 0, 1, }));
  }

  @Test
  public void testShitWorks() {
    data = (ArrayList<Integer>) Merge.sort(data);

    System.out.println(data);
    for (int i = 0; i < data.size() - 1; i++) {
      assertTrue(data.get(i) <= data.get(i + 1));
    }
  }

}
