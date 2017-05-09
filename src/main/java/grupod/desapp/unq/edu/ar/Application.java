package grupod.desapp.unq.edu.ar; /**
 * Created by gabriel on 02/05/17.
 */

import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.persistence.ProductDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Bean
    public CommandLineRunner demo(ProductDAO repository) {
        return (args) -> {
            IntStream.range(1, 5).forEach(i -> {
                Product product = new Product();
                product.setId(i);
                product.setName(String.format("Producto %d", i));
                product.setBrand(String.format("Marca %d", i));
                repository.save(product);
            });

        };
    }*/


}
