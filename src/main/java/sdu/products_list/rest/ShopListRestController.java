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


}
