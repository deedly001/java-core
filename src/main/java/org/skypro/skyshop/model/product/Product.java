package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;
import java.util.stream.Stream;

public abstract class Product implements Searchable {
    private String productName;
    final UUID id;

    public Product(String productName, UUID id) {
        this.productName = productName;
        this.id = id;
        checkName(productName);
    }

    public String getProductName() {
        return productName;
    }


    public void setProductName(String name) {
        this.productName = name;
    }

    public String getProductType() {
        return "PRODUCT";
    }

    private void checkName(String productName) throws IllegalArgumentException {
        if (productName != null) {
            if (productName.isBlank()) {
                throw new IllegalArgumentException(("Наименование продукта: \"" + productName + "\"" + " указано неверно"));
            }
        } else {
            throw new NullPointerException(("Наименование продукта не может быть = 'Null'"));
        }
    }

    @JsonIgnore
    public String getSearchTerm() {
        return "name: " + getProductName() + " type: " + getProductType();
    }

    @JsonIgnore
    @Override
    public String getSearchContentType() {
        return getProductType();
    }

    @Override
    public UUID getId() {
        return id;
    }

    public Integer getPrice() {
        return null;
    }

    public void setPrice(Integer cost) {
    }

    public Stream<?> stream() {
        return Stream.empty();
    }

    public boolean isSpecial() {
        return false;
    }

    public abstract UUID getID();
}