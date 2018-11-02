package com.paradm.designpatterns;

import java.util.Iterator;

import com.paradm.designpatterns.iterator.Book;
import com.paradm.designpatterns.iterator.BookShelf;

public class IteratorTest {
  public static void main(String[] args) {
    BookShelf bookShelf = new BookShelf();
    bookShelf.appendBook(new Book("Around the World in 80 Days"));
    bookShelf.appendBook(new Book("Bible"));
    bookShelf.appendBook(new Book("Cinderella"));
    bookShelf.appendBook(new Book("Daddy-Long-legs"));
    Iterator<Book> it = bookShelf.iterator();
    while (it.hasNext()) {
      System.out.println(it.next().getName());
    }
  }
}
