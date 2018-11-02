package com.paradm.designpatterns;

import com.paradm.designpatterns.adapter.CPrint;
import com.paradm.designpatterns.adapter.IPrint;
import com.paradm.designpatterns.adapter.PrintBanner1;
import com.paradm.designpatterns.adapter.PrintBanner2;

public class AdapterTest {
  public static void main(String[] args) {
    IPrint p = new PrintBanner1("Hello World!");
    p.printWeak();
    p.printStrong();
    CPrint p2 = new PrintBanner2("Hello World too!");
    p2.printWeak();
    p2.printStrong();
  }
}
