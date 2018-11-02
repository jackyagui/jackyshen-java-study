package com.paradm.designpatterns;

import com.paradm.designpatterns.prototype.Manager;
import com.paradm.designpatterns.prototype.MessageBox;
import com.paradm.designpatterns.prototype.Product;
import com.paradm.designpatterns.prototype.UnderlinePen;

public class PrototypeTest {

  public static void main(String[] args) {
    Manager manager = new Manager();
    UnderlinePen upen = new UnderlinePen('~');
    MessageBox mBox = new MessageBox('*');
    MessageBox sBox = new MessageBox('/');
    manager.register("strong message", upen);
    manager.register("warning box", mBox);
    manager.register("slash box", sBox);
    Product p1 = manager.create("strong message");
    p1.use("hello, world.");
    Product p2 = manager.create("warning box");
    p2.use("hello, world.");
    Product p3 = manager.create("slash box");
    p3.use("hello, world.");
  }

}
