package ru.stqa.pft.sandbox;

/**
 * Created by HoncaRo on 2017-07-31.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public static double distance(Point p1, Point p2) {
    double dx = p1.x - p2.x;
    double dy = p1.y - p2.y;
    return Math.sqrt(dx * dx - dy * dy);
  }

}