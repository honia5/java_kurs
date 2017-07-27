package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("User");
    hello("Robert");

    double len = 5;
    System.out.println("Pole kwadratu o boku " + len + " = " + (area(len)));

    double a = 4;
    double b = 6;
    System.out.println("Pole prostokata o bokach " + a + " i " + b +" = " + (area(a, b)));

  }

  public static void hello(String somebody) {

    System.out.println("Hello," + somebody + "!");
  }
  public static double area(double l){
    return l * l;
  }
  public static double area(double a, double b){
    return a * b;
  }
}