package com.paradm.designpatterns.singleton;

public class Singleton4 {
  private static Singleton4 instance = null;

  private Singleton4() {}

  public static Singleton4 getInstance() {
    if (null == instance) {
      synchronized (Singleton4.class) {
        if (null == instance) {
          instance = new Singleton4();
        }
      }
    }
    return instance;
  }
}
