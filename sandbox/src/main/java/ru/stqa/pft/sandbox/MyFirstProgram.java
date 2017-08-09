package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("User");
    hello("Robert");

    Square s = new Square(5);
    System.out.println("Pole kwadratu o boku " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Pole prostokata o bokach " + r.a + " i " + r.b + " = " + r.area());


    Point p = new Point(1, 1, 4, 4);
    System.out.println("Distance between two points " + "(" + p.x1 + "," + p.y1 + ")," + "(" + p.x2 + "," + p.y2 + ") = " + p.distance());

  }

  public static void hello(String somebody) {

    System.out.println("Hello," + somebody + "!");
  }


}