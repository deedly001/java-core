package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public abstract class Product implements Searchable {
    private String productName;
    private final UUID id;

    public Product(String productName, UUID id) {
        this.productName = productName;
        this.id = id;
        checkName(productName);
    }

    public String getProductName() {
        return productName;
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


    public UUID getId() {
        return id;
    }

    public abstract Integer getPrice();


    public boolean isSpecial() {
        return false;
    }

}