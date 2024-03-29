import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class AverageTest {

  static final double DELTA = 0.000000001;

  @Test
  public void testAverage0() {
    final var temps = Collections.<Double>emptyList();
    final var actual = Average.calculateStats(temps);
    assertEquals(null, actual);
  }

  private void testAverage(
      final List<Double> temps, final double expectedAverage, final int expectedCountAboveAverage) {
    final var actual = Average.calculateStats(temps);
    assertEquals(expectedAverage, actual.average, DELTA);
    assertEquals(expectedCountAboveAverage, actual.countAboveAverage);
  }

  @Test
  public void testAverage1() {
    testAverage(List.of(3.4), 3.4, 0);
  }

  @Test
  public void testAverage2() {
    testAverage(List.of(3.4, 3.6), 3.5, 1);
  }
}
