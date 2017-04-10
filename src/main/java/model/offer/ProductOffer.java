package model.offer;

import model.ListItem;
import model.Product;
import model.ShoppingList;

import java.time.LocalDate;

/**
 * Created by gabriel on 10/04/17.
 */
public class ProductOffer extends Offer {
    private Product product;

    public ProductOffer(LocalDate startDate, LocalDate endDate, double discount, Product product){
        super(startDate, endDate, discount);
        this.product = product;
    }

    public ProductOffer(){

    }

    @Override
    public boolean appliesTo(ListItem item) {
        return this.product.equals(item.getProduct());
    }

    @Override
    public boolean appliesTo(ShoppingList list) {
        // TODO
        return false;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
