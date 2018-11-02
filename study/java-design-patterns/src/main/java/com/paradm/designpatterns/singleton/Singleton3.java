package com.paradm.designpatterns.singleton;

public class Singleton3 {
  private static Singleton3 instance = null;

  private Singleton3() {}

  public synchronized static Singleton3 getInstance() {
    if (null == instance) {
      instance = new Singleton3();
    }
    return instance;
  }
}
