package com.paradm.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory<IDCard> {

  private List<String> cardList = new ArrayList<String>();

  public List<String> getCardList() {
    return cardList;
  }

  @Override
  protected IDCard createProduct(String owner) {
    return new IDCard(owner);
  }

  @Override
  protected void registerProduct(IDCard e) {
    cardList.add(e.getOwner());
  }

}
