package com.example.eshop.editor;

import com.example.eshop.model.Product;

import java.util.List;

public class ProductListEditor {


    public List<Product> editList(List<Product> products) {
        int i = 0;
        for (Product product : products) {
            //Here you can delete/add/change method
            productModelToUpperCase(product);
            productDescriptionToLowerCase(product);
            products.set(i, product);
            i++;
        }
        return products;
    }

    private void productModelToUpperCase(Product product) {
        product.setModel(product.getModel().toUpperCase());
    }

    private void productDescriptionToLowerCase(Product product) {
        product.setDescription(product.getDescription().toLowerCase());
    }
}

