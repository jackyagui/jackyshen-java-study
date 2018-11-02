package com.paradm.designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager {
  private Map<String, Product> showCase = new HashMap<String, Product>();

  public void register(String name, Product product) {
    showCase.put(name, product);
  }

  public Product create(String productName) {
    Product p = showCase.get(productName);
    return p.createClone();
  }
}
