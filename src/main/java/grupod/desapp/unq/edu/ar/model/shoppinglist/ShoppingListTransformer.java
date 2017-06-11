package grupod.desapp.unq.edu.ar.model.shoppinglist;

import grupod.desapp.unq.edu.ar.model.exceptions.ItemAlreadyExistsException;
import grupod.desapp.unq.edu.ar.services.ShoppingListService;

/**
 * Created by gabriel on 11/06/17.
 */
public class ShoppingListTransformer {

    public static ArchivedShoppingList serialize(ShoppingList list){
        ArchivedShoppingList result = new ArchivedShoppingList(list.getName(), list.getUser().getUsername());
        list.getItems().forEach(listItem -> result.getItems().add(serialize(listItem)));

        return result;
    }

    private static ArchivedListItem serialize(ListItem item){
        return new ArchivedListItem(item.getProduct().getName(), item.getProduct().getId(), item.getQuantity());
    }

    private static ListItem deserialize(ArchivedListItem item){
        return new ListItem(new Product(item.getProductID()), item.getQuantity());
    }

    public static ShoppingList deserialize(ArchivedShoppingList list, ShoppingListService service){
        final ShoppingList result = service.create(new ShoppingList(list.getName()), list.getUsername());

        list.getItems().forEach(archivedListItem -> {
            try {
                service.addItem(result.getId(), deserialize(archivedListItem));
            } catch (ItemAlreadyExistsException e) {
                e.printStackTrace();
            }
        });

        return result;
    }
}
