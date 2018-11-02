package com.paradm.designpatterns;

import com.paradm.designpatterns.factory.Factory;
import com.paradm.designpatterns.factory.IDCard;
import com.paradm.designpatterns.factory.IDCardFactory;

public class FactoryTest {

  public static void main(String[] args) {
    Factory<IDCard> f = new IDCardFactory();
    IDCard card = f.create("xiao ming");
    // if (!Utility.isEmpty(card)) {
      card.use();
    // }
  }

}
