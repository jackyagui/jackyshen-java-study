package com.paradm.designpatterns.singleton;

public class Singleton5 {
  private Singleton5() {}

  private static class SingletonHolder {
    private final static Singleton5 instance = new Singleton5();
  }

  public static Singleton5 getInstance() {
    return SingletonHolder.instance;
  }
}
