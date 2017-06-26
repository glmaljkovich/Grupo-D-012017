package grupod.desapp.unq.edu.ar.controllers;

import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 09/05/17.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController extends LoggingController{

    @Autowired
    private ProductService productService;

    @PostMapping(headers = "content-type=application/json")
    public ResponseEntity create(@RequestBody Product product) {
        Integer id;
        try {
            id = productService.addProduct(product);
            logger.info("Product added: {}", product);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().body("Error creating the product");
        }
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public List<Product> find(@RequestParam("criteria") String criteria, Pageable pageable) {
        Page<Product> page;
        try {
             page = productService.find(criteria, pageable);
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
        return page.getContent();
    }

    @PostMapping("/upload")
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file) {
        Integer count = 0;
        try {
            count = productService.uploadProducts(file);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(count.toString() + " productos subidos correctamente");
    }
}
