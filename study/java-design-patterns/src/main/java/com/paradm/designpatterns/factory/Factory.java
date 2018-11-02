package com.paradm.designpatterns.factory;

public abstract class Factory<E> {
  public final E create(String owner) {
    E e = createProduct(owner);
    registerProduct(e);
    return e;
  }

  protected abstract E createProduct(String owner);

  protected abstract void registerProduct(E e);
}
