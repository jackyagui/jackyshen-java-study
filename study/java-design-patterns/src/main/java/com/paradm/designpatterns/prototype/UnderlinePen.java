package com.paradm.designpatterns.prototype;

public class UnderlinePen implements Product {
  private char ulchar;

  public UnderlinePen(char ulchar) {
    this.ulchar = ulchar;
  }

  @Override
  public void use(String str) {
    int length = str.getBytes().length;
    System.out.println("\"" + str + "\"");
    System.out.print(" ");
    for (int i = 0; i < length; i++) {
      System.out.print(ulchar);
    }
    System.out.println("");
  }

  @Override
  public Product createClone() {
    Product p = null;
    try {
      p = (Product) clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return p;
  }

}
