package com.paradm.designpatterns.iterator;

import java.util.Iterator;

public interface Aggregate {

  public abstract Iterator<?> iterator();
}
