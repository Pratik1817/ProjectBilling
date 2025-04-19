package restaurant.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import restaurant.billing.model.MenuItem;
import restaurant.billing.repository.MenuItemRepository;

@Service
public class MenuService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem createMenuItem(MenuItem menuItem) {
    return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems()
    {
        return menuItemRepository.findAll();
    }

    public boolean updateMenuItem(long id , MenuItem updateMenuItem)
    {
        Optional<MenuItem> optionalItem = menuItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            MenuItem item = optionalItem.get();
            item.setName(updateMenuItem.getName());
            item.setPrice(updateMenuItem.getPrice());
            item.setCategory(updateMenuItem.getCategory());
            item.setAvailable(updateMenuItem.isAvailable());
            menuItemRepository.save(item);
            return true;
        }
        else{
            return false;
        }
    }

    public  List<MenuItem> searchItem(String name)
    {
        return menuItemRepository.findByName(name);
    }

    public Optional<MenuItem> searchItemById(long id)
    {
        return menuItemRepository.findById(id);
    }
    public boolean deleteMenuItem(long id)
    {
        if (menuItemRepository.existsById(id)) {
            menuItemRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

}
