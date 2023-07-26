package sdu.products_list.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.products_list.entity.ShopList;
import sdu.products_list.service.ShopListService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopListRestController {

    @Autowired
    private ShopListService shopListService;

    @GetMapping("/shoplist")
    public List<ShopList> findAll(){
        return shopListService.findAll();
    }

    @GetMapping("/shoplist/{shopListId}")
    public ShopList getShopList(@PathVariable int shopListId){

        ShopList theShopList = shopListService.findById(shopListId);

        if(theShopList == null){
            throw new RuntimeException("The product is not found - " + shopListId);
        }

        return theShopList;

    }

    @PostMapping("/shoplist")
    public ShopList addShopList(@RequestBody ShopList theShopList){

        theShopList.setId(0);

        ShopList dbShopList = shopListService.save(theShopList);

        return dbShopList;
    }

    @PutMapping("/shoplist")
    public ShopList updateShopList(@RequestBody ShopList theShopList){

        ShopList dbShopList = shopListService.save(theShopList);
        return dbShopList;

    }

    @DeleteMapping("/shoplist/{shopListId}")
    public String deleteShopList(@PathVariable int shopListId) {

        ShopList tempShopList = shopListService.findById(shopListId);

        if(tempShopList == null){
            throw new RuntimeException("Product is not found - " + shopListId);
        }

        shopListService.deleteById(shopListId);
        return "delete product id " + shopListId;
    }

}
