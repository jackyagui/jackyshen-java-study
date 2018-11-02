package com.paradm.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Aggregate {

  private List<Book> bookList;
  private int last = 0;

  public BookShelf() {
    this.bookList = new ArrayList<Book>();
  }

  public Book getBookAt(int index) {
    return bookList.get(index);
  }

  public void appendBook(Book book) {
    this.bookList.add(book);
    last++;
  }

  public int getLength() {
    return last;
  }

  @Override
  public Iterator<Book> iterator() {
    return new BookShelfIterator(this);
  }

}
