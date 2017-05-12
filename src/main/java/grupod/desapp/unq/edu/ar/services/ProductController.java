package grupod.desapp.unq.edu.ar.services;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.persistence.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping(method = GET)
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

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            String input = new String(file.getBytes());
            ObjectMapper mapper = new ObjectMapper();
            Product[] readValue = mapper.readValue(input, Product[].class);
            List<Product> products = Arrays.asList(readValue);
            productDAO.save(products);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
