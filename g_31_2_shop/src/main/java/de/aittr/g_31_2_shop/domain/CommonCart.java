package de.aittr.g_31_2_shop.domain;

import de.aittr.g_31_2_shop.domain.interfaces.Cart;
import de.aittr.g_31_2_shop.domain.interfaces.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonCart implements Cart {

    private int id;
    private List<Product> products = new ArrayList<>();

    public CommonCart() {
    }

    public CommonCart(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProductById(int productId) {
        products.removeIf(x -> x.getId() == productId);
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public double getTotalPrice() {
        return products.stream()
                .filter(x -> x.isActive())
                .mapToDouble(x -> x.getPrice())
                .sum();
    }

    @Override
    public double getAveragePrice() {
        return products.stream()
                .filter(x -> x.isActive())
                .mapToDouble(x -> x.getPrice())
                .average()
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCart that = (CommonCart) o;
        return id == that.id && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
