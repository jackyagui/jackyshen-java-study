package com.paradm.designpatterns.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder {
  private String fileName;
  private PrintWriter pw;

  @Override
  public void makeTitle(String title) {
    fileName = title + ".html";
    try {
      pw = new PrintWriter(new FileWriter(fileName));
      pw.println("<html><head><title>" + title + "</title></head><body>");
      pw.println("<h1>" + title + "</h1>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void makeString(String str) {
    pw.println("<p>" + str + "</p>");
  }

  @Override
  public void makeItems(String[] items) {
    pw.println("<ul>");
    for (int i = 0; i < items.length; i++) {
      pw.println("<li>" + items[i] + "</li>");
    }
    pw.println("</ul>");
  }

  @Override
  public void close() {
    pw.println("</body></html>");
    pw.close();
  }

  public String getResult() {
    return fileName;
  }

}
