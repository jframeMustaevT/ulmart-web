package ru.itpark.ozon.service;

import org.springframework.stereotype.Service;
import ru.itpark.ozon.domain.Book;
import ru.itpark.ozon.repository.BookRepository;

@Service
public class BookService { // new BookService(-> <-);
  private BookRepository repository;
  private int nextId = 1;

  public BookService(BookRepository repository) {
    this.repository = repository;
  }

  public void add(String title, String author) {
    // int count = 10;
    Book book = new Book(nextId, title, author);
    repository.add(book);
    nextId++;
  }

  public Book[] getAll() {
    return repository.getAll();
  }

  public Book getById(int id) {
    return repository.getById(id);
  }

  public void updateById(int id, String title, String author) {
    Book book = new Book(id, title, author);
    repository.update(book);
  }

  public void removeById(int id) {
    repository.removeById(id);
  }

  public Book[] search(String search) {
    Book[] result = new Book[10]; // макс.кол-во
    Book[] all = repository.getAll();
    int nextIndex = 0;
    for (Book book : all) {
      if (book != null && book.getTitle().contains(search)) {
        result[nextIndex] = book;
        nextIndex++;
      }
      // TODO: следить, что nextIndex < 10
    }

    return result;
  }
}
