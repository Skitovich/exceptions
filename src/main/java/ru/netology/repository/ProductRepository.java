package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class ProductRepository {
    public Collection<Product> items = new ArrayList<>();

    public void save(Product item) {
        items.add(item);
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }

        }
        return null;
    }

    public Product[] findAll() {
        return items.toArray(Product[]::new);
    }

    public void removeById(int id) {
    items.removeIf(p -> p.getId() == id);
    }

    public void saveAll (Collection<Product> collection) {
        items.addAll(collection);
    }
    public void removeAll (Collection<Product> collection) {
        items.removeAll(collection);
    }
}