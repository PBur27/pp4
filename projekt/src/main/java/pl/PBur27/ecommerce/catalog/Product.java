package pl.PBur27.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String id;
    private final String name;

    private BigDecimal price;
    private final String description;
    public Product(UUID id, String name, String description) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
        price = BigDecimal.valueOf(0);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getId() {
        return this.id;
    }

    public void changePrice(BigDecimal price){
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
