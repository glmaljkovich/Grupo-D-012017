package grupod.desapp.unq.edu.ar.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.persistence.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gabriel on 23/05/17.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public Integer addProduct(Product product){
        Product saved = productDAO.save(product);
        return saved.getId();
    }

    public Page<Product> find(String criteria, Pageable pageable){
        return productDAO.findProductsByNameContainingOrBrandContainingAllIgnoreCase(criteria, criteria,pageable);
    }

    public Integer uploadProducts(MultipartFile file) throws IOException {
        String input = new String(file.getBytes());
        ObjectMapper mapper = new ObjectMapper();
        Product[] readValue = mapper.readValue(input, Product[].class);
        List<Product> products = Arrays.asList(readValue);
        products.forEach(product -> {
            Product existing = productDAO.findByNameAndBrand(product.getName(), product.getBrand());
            if(existing != null){
                product.setId(existing.getId());
            }
            productDAO.save(product);
        });
        return products.size();
    }
}
