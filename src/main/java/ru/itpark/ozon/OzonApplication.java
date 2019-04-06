package ru.itpark.ozon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itpark.ozon.controller.BookController;
import ru.itpark.ozon.repository.BookRepository;
import ru.itpark.ozon.service.BookService;

@SpringBootApplication
public class OzonApplication {

  public static void main(String[] args) {
    SpringApplication.run(OzonApplication.class, args);

//    BookRepository repository = new BookRepository();
//    BookService service = new BookService(repository);
//    BookController controller = new BookController(service);
  }

}
