package com.paradm.designpatterns.adapter;

public class PrintBanner1 extends Banner implements IPrint {

  public PrintBanner1(String str) {
    super(str);
  }

  @Override
  public void printWeak() {
    showWithParen();
  }

  @Override
  public void printStrong() {
    showWithAster();
  }

}
