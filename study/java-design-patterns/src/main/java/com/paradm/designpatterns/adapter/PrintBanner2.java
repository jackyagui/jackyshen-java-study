package com.paradm.designpatterns.adapter;

public class PrintBanner2 extends CPrint {

  private Banner banner;

  public PrintBanner2(String str) {
    this.banner = new Banner(str);
  }

  @Override
  public void printWeak() {
    banner.showWithParen();
  }

  @Override
  public void printStrong() {
    banner.showWithAster();
  }

}
