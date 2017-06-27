package grupod.desapp.unq.edu.ar; /**
 * Created by gabriel on 02/05/17.
 */

import grupod.desapp.unq.edu.ar.model.Price;
import grupod.desapp.unq.edu.ar.model.cashregister.CashRegister;
import grupod.desapp.unq.edu.ar.model.exceptions.ItemAlreadyExistsException;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ListItem;
import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.model.user.AccessLevel;
import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.persistence.*;
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

    @Bean
    public CommandLineRunner demo(ProductDAO productDAO, UserDAO userDAO, ShoppingListDAO shoppingListDAO, ListItemDAO listItemDAO, CashRegisterDAO cashRegisterDAO) {
        return (args) -> {
            /*Create User*/
            User user = new User("pepe27", "1234", "pe@pe.com");
            user.setAccessLevel(AccessLevel.ADMIN);
            userDAO.save(user);

            /*Create ShoppingList*/
            ShoppingList list = new ShoppingList();
            list.setUser(user);
            list.setName("Compras");

            /*Create products*/
            IntStream.range(1, 5).forEach(i -> {
                Product product = new Product();
                product.setName(String.format("Producto %d", i));
                product.setBrand(String.format("Marca %d", i));
                product.setPrice(new Price(10,50));
                product.setTime(i*5);
                productDAO.save(product);
                ListItem item = new ListItem(product, i);
                listItemDAO.save(item);
                try {
                    list.addItem(item);
                } catch (ItemAlreadyExistsException e) {
                    e.printStackTrace();
                }
            });

            /*Create Cash Registers*/
            IntStream.range(1, 5).forEach(i -> {
                CashRegister register = new CashRegister();
                register.setWaitingTime(i*10);
                cashRegisterDAO.save(register);
            });

            shoppingListDAO.save(list);
        };
    }


}
