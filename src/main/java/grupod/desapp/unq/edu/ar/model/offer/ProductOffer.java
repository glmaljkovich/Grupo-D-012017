package grupod.desapp.unq.edu.ar.model.offer;

import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;

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

        return list.getItems().stream().anyMatch(item -> item.getProduct().equals(this.getProduct()));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
