package de.aittr.g_31_2_shop.domain.interfaces;

import java.util.List;

public interface Cart {

    int getId();

    List<Product> getProducts();

    void  addProduct(Product product);

    void deleteProductById(int productId);

    void clear();//очищает корзину

    double getTotalPrice();//возвращает полную стоимость товара

    double getAveragePrice();//возвращает среднюю стоимость товара в корзине

}
