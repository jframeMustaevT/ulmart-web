package ru.itpark.ozon.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.ozon.service.BookService;

@Controller
@AllArgsConstructor // сгенерирует конструктор
public class BookController {
  private BookService service;

  // mapping -> привязка метода к обработке URL'а
  @GetMapping // RequestMapping: http://localhost:8080/ -> GET, POST, PUT, DELETE, @GetMapping только на GET
  public String frontPage(Model model) {
    model.addAttribute("books", service.getAll());
    return "index"; // строчка с именем шаблона (без расширения)
  }

  @GetMapping(params = "search") // params указали, чтобы не было конфликта с предыдущим маппингом
  public String searchPage(@RequestParam String search, Model model) {
    model.addAttribute("books", service.search(search));
    model.addAttribute("search", search);
    return "index";
  }

  // обработка только GET-запросов (переход по ссылке, адрес в адресной строке браузера)
  @GetMapping("/add") // http://localhost:8080/add
  public String addPage() {
    return "add";
  }

  @PostMapping("/add") // равносильно @RequestMapping(value = "/add", method = "POST")
  // title должен быть равен тому, что в форме name (name="title")
  public String add(@RequestParam String title, @RequestParam String author) {
    service.add(title, author);
    return "redirect:/"; // "редиректим на главную"
  }

  @GetMapping("/view/{id}") // в {id} будут класться значения (должно соответствовать имени параметра)
  public String viewPage(@PathVariable int id, Model model) {
    model.addAttribute("book", service.getById(id));
    return "view";
  }

  @GetMapping("/edit/{id}")
  public String editPage(@PathVariable int id, Model model) {
    model.addAttribute("book", service.getById(id));
    return "edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(
      @PathVariable int id,
      @RequestParam String title,
      @RequestParam String author
  ) {
    service.updateById(id, title, author);
    return "redirect:/";
  }

  @PostMapping("/remove/{id}")
  public String remove(@PathVariable int id) {
    service.removeById(id);
    return "redirect:/";
  }
}
