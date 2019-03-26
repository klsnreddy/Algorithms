package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TowersOfHanoiTest {

  @Test
  public void performHanoi() {
    TowersOfHanoi hanoi = new TowersOfHanoi(5);
    System.out.println(hanoi.getSrc().toString());
    hanoi.performHanoi();
    System.out.println(hanoi.getDest().toString());
    assertEquals("Source peg is not empty",0, hanoi.getSrc().size());
    assertEquals("Dest peg does not have all rings",5, hanoi.getDest().size());
    assertEquals("Moves are not right", 31, hanoi.getMoves());
  }
}