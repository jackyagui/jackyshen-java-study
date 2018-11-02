package com.jackyshen;

import java.util.Collection;

public class Utility {

  public static boolean isEmpty(String str) {
    return (null == str || "".equals(str) || "".equals(str.trim()));
  }

  public static boolean isEmpty(StringBuffer sb) {
    return (null == sb || sb.length() == 0 || "".equals(sb.toString().trim()));
  }

  public static boolean isEmpty(Object[] array) {
    return (null == array || array.length == 0);
  }

  public static boolean isEmpty(Object obj) {
    return (null == obj);
  }

  public static <T> boolean isEmpty(Collection<T> c) {
    return (null == c || c.isEmpty());
  }
}
