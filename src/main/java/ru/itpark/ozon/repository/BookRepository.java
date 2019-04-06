package ru.itpark.ozon.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.ozon.domain.Book;

@Repository
public class BookRepository { // new BookRepository();
  private Book[] items = new Book[10]; // 10 - null
  private int nextIndex = 0;

  public Book[] getAll() {
    return items;
  }

  public void add(Book book) {
    // TODO: проверить размер (items)
    items[nextIndex] = book;
    nextIndex++;
  }

  public void update(Book book) {
    // itar + tab
    for (int i = 0; i < items.length; i++) {
      Book item = items[i];
      if (item != null && item.getId() == book.getId()) {
        items[i] = book; // заменяем объект
        return;
      }
    }
  }

  public void removeById(int id) {
    for (int i = 0; i < items.length; i++) {
      Book item = items[i];
      if (item != null && item.getId() == id) {
        items[i] = null;
        // TODO: подыскать более удобный контейнер
        return;
      }
    }
  }

  public Book getById(int id) {
    for (Book item : items) {
      if (item != null && item.getId() == id) {
        return item;
      }
    }
    return null;
  }
}
