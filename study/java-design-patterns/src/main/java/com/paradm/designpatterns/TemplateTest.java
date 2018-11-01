package com.paradm.designpatterns;

import com.paradm.designpatterns.template.AbstractDisplay;
import com.paradm.designpatterns.template.StringDisplay;

public class TemplateTest {

  public static void main(String[] args) {
    AbstractDisplay ad = new StringDisplay("Hello, world.");
    ad.display();
  }

}
