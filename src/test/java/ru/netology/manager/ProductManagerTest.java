package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exceptions.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    private Product product = new Product(1, "Rus", 100);
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);


    private Product first = new Book(1, "Оно", 100, "Рус");
    private Product second = new Smartphone(2, "айфон", 1000, "апл");
    private Product third = new Smartphone(3, "sam", 500, "китай");
    private Product forth = new Book(4, "Валя", 100, "Галя");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        repository.findAll();
    }

    @Test
    void shouldCallNotFoundException() {
        assertThrows(NotFoundException.class, () -> manager.removeById(5));
    }

    @Test
    void removeById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Product[] actual = new Product[]{first, second};
        Product[] expected = repository.findAll();
        assertArrayEquals(actual, expected);

    }
}