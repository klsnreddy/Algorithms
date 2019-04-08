package dp;

import static org.junit.Assert.*;

import dp.KnapSackValue.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class KnapSackValueTest {

  @Test
  public void knapSackValue() {
    List<Item> items = Arrays.asList(
        new Item(5, 60),
        new Item(3, 50),
        new Item(4, 70),
        new Item(2, 30));

    assertEquals("<5, 3> should be considered", 120,
        KnapSackValue.knapSackValue(items, 8));
    assertEquals("<4, 3, 2> should be considered", 150,
        KnapSackValue.knapSackValue(items, 9));
  }
}