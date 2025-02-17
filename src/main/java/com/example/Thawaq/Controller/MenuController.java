package com.example.Thawaq.Controller;

import com.example.Thawaq.Model.Menu;
import com.example.Thawaq.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/get")
    public ResponseEntity getAllMenu() {
        return ResponseEntity.status(200).body(menuService.getAllMenus());
    }
    @PostMapping("/add/{CategoryId}")
    public ResponseEntity addMenu(@RequestBody Menu menu,@PathVariable Integer CategoryId) {
        menuService.addMenu(menu,CategoryId);
        return ResponseEntity.status(200).body("added successfully");

    }
    @PutMapping("/update/{MenuId}/{CategoryId}")
    public ResponseEntity updateMenu(@RequestBody Menu menu,@PathVariable Integer MenuId,@PathVariable Integer CategoryId) {
        menuService.updateMenu(menu,MenuId,CategoryId);
        return ResponseEntity.status(200).body("updated successfully");
    }

    @DeleteMapping("/delete/{MenuId}")
    public ResponseEntity deleteMenu(@PathVariable Integer MenuId) {
        menuService.deleteMenu(MenuId);
        return ResponseEntity.status(200).body("deleted successfully");
    }

    //Find dish by price range min and max (Jana) v2
    @GetMapping("/get-By-price-range")
    public ResponseEntity findDishesByPriceRange(@PathVariable double priceMin, @PathVariable double priceMax) {
        return ResponseEntity.status(200).body(menuService.findDishesByPriceRange(priceMin, priceMax));
    }
}
