package grupod.desapp.unq.edu.ar.model.shoppinglist;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "archivedListItem")
public class ArchivedListItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 1000)
    private String product;
    private Integer productID;
    private int quantity;

    public ArchivedListItem(String product, Integer productID, Integer quantity) {
        this.product    = product;
        this.quantity   = quantity;
        this.productID  = productID;
    }

    public ArchivedListItem() {}

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
