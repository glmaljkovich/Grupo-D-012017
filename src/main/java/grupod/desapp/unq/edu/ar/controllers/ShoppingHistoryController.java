package grupod.desapp.unq.edu.ar.controllers;

import com.fasterxml.jackson.databind.JsonSerializer;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ArchivedShoppingList;
import grupod.desapp.unq.edu.ar.model.shoppinglist.ShoppingList;
import grupod.desapp.unq.edu.ar.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gabriel on 06/06/17.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/history/{username}")
public class ShoppingHistoryController {

    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping
    public ResponseEntity<Page<ArchivedShoppingList>> getShoppingListHistory(@PathVariable String username, Pageable pageable){
        Page<ArchivedShoppingList> result = shoppingListService.getHistoryForUser(username, pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<String> archiveShoppingList(@PathVariable String username, @RequestBody Integer id){
        shoppingListService.addToHistory(id);
        return ResponseEntity.ok("Lista agregada a su historial");
    }

    @PostMapping("/copy/{id}")
    public ResponseEntity<String> copyArchivedShoppingList(@PathVariable Integer id){
        shoppingListService.copy(id);
        return ResponseEntity.ok("Lista copiada correctamente.");
    }
}
