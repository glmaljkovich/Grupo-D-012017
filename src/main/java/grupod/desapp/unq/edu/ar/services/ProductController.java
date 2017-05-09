package grupod.desapp.unq.edu.ar.services;

import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by gabriel on 09/05/17.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;


    @RequestMapping(method = POST, headers = "content-type=application/json")
    @ResponseBody
    public String create(@RequestBody Product product) {
        String productName = "";
        try {
            productDAO.save(product);
            productName = String.valueOf(product.getName());
        }
        catch (Exception ex) {
            return "Error creating the product: " + ex.toString();
        }
        return "User succesfully created with id = " + productName;
    }

    @RequestMapping(value = "/find", method = GET)
    @ResponseBody
    public List<Product> find(@RequestParam("criteria") String criteria, Pageable pageable) {
        Page<Product> page;
        try {
             page = productDAO.findProductsByNameContainingOrBrandContainingAllIgnoreCase(criteria, criteria,pageable);
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
        return page.getContent();
    }
}
