package com.paradm.designpatterns.builder;

public class TextBuilder extends Builder {
  private StringBuilder sb = new StringBuilder();

  @Override
  public void makeTitle(String title) {
    sb.append("=========================\n");
    sb.append("¡º" + title + "¡»");
    sb.append("\n");
  }

  @Override
  public void makeString(String str) {
    sb.append("¡ö" + str + "\n");
    sb.append("\n");
  }

  @Override
  public void makeItems(String[] items) {
    for (int i = 0; i < items.length; i++) {
      sb.append("  ." + items[i] + "\n");
    }
    sb.append("\n");
  }

  @Override
  public void close() {
    sb.append("=========================\n");
  }

  public String getResult() {
    return sb.toString();
  }

}
