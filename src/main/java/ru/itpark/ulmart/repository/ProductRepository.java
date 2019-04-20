package ru.itpark.ulmart.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.ulmart.domain.*;

@Repository
public class ProductRepository {
  private Product[] items = new Product[10]; // 10 - null
  private int nextIndex = 0;

  public ProductRepository() {
    // FIXME: bad hack
    IPhone iPhone = new IPhone();
    iPhone.setId(1);
    iPhone.setName("iPhone XR");
    iPhone.setPrice(64_000);
    iPhone.setModel("XR");
    iPhone.setOs("iOS");
    iPhone.setMemorySize(64);
    iPhone.setColor("Pink Gold");

    TShirt shirt = new TShirt();
    shirt.setId(2);
    shirt.setName("T-Shirt Nike");
    shirt.setPrice(1_000);
    shirt.setSize(52);
    shirt.setColor("Black");
    shirt.setMaterial("cotton");

    Watch watch = new Watch();
    watch.setId(3);
    watch.setName("Watch Casio");
    watch.setCaseSize(57);
    watch.setColor("Black");
    watch.setCaseMaterial("Stainless steel");
    watch.setPrice(154_000);

    Desktop desktop =new Desktop();
    desktop.setId(4);
    desktop.setName("Laptop Apple ");
    desktop.setPrice(160_000);
    desktop.setColor("White");
    desktop.setMemorySpeed("1600 МHz");
    desktop.setHardDrive("1 TB");


    add(iPhone);
    add(shirt);
    add(watch);
    add(desktop);
  }

  public Product[] getAll() {
    return items;
  }

  public void add(Product product) {
    // TODO: проверить размер (items)
    items[nextIndex] = product;
    nextIndex++;
  }

  public Product getById(int id) {
    for (Product item : items) {
      if (item != null && item.getId() == id) {
        return item;
      }
    }
    return null;
  }
}
