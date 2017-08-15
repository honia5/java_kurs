package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by HoncaRo on 2017-08-15.
 */
public class PointTests {
  Point p1 = new Point(1, 1);
  Point p2 = new Point(1, 4);

  @Test
  public void testDeterminingCoordinates() {

    Assert.assertEquals(p2.x - p1.x, 0.0);
    Assert.assertEquals(p2.y - p1.y, 3.0);
  }

  @Test
  public void testCoordinatePower() {
    Assert.assertEquals((p2.x - p1.x) * (p2.x - p1.x), 0.0);
    Assert.assertEquals((p2.y - p1.y) * (p2.y - p1.y), 9.0);
  }

  @Test
  public void testCoordinatePowerWithAFunction() {
    Assert.assertEquals(Math.pow(0, 2), 0.0);
    Assert.assertEquals(Math.pow(3, 2), 9.0);
  }

  @Test
  public void testCoordinatesExtractionOfARoot() {
    Assert.assertEquals(Math.sqrt(0), 0.0);
    Assert.assertEquals(Math.sqrt(9), 3.0);
  }

  @Test
  public void testDistance() {
    Assert.assertEquals(p1.distance(p2), 3.0);
  }
}
