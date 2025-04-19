package restaurant.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant.billing.model.MenuItem;
import restaurant.billing.service.MenuService;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:5173")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem)
    {
        return ResponseEntity.ok(menuService.createMenuItem(menuItem));
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems()
    {
        return menuService.getAllMenuItems();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMenuItem(@PathVariable long id ,@RequestBody MenuItem upMenuItem)
    {
       boolean updated = menuService.updateMenuItem(id, upMenuItem);
       return updated ? ResponseEntity.ok("Items Updated Successfully...") : ResponseEntity.notFound().build();
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<MenuItem>> searchByName(@PathVariable String name) {
    List<MenuItem> items = menuService.searchItem(name);
    return ResponseEntity.ok(items);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity <MenuItem> searchItemById(@PathVariable long id)
    {
        return menuService.searchItemById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMenuItem (@PathVariable long id)
    {
        Boolean d = menuService.deleteMenuItem(id);
        if (d) {
            return ResponseEntity.ok("Item deleted successfully...");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
