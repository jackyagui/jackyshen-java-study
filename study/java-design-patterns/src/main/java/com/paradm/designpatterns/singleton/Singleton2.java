package com.paradm.designpatterns.singleton;

public class Singleton2 {
  private static Singleton2 instance = null;

  private Singleton2() {}

  public static Singleton2 getInstance() {
    if (null == instance) {
      instance = new Singleton2();
    }
    return instance;
  }
}
