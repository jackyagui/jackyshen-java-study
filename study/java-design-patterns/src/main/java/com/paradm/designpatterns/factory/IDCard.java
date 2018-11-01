package com.paradm.designpatterns.factory;

public class IDCard extends Product {

  private String owner;

  public IDCard(String owner) {
    System.out.println("create " + owner + "'s ID card.");
    this.owner = owner;
  }

  @Override
  public void use() {
    System.out.println("use " + owner + "'s ID card.");
  }

  public String getOwner() {
    return owner;
  }
}
