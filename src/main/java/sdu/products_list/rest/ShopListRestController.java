package sdu.products_list.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.service.ShopListService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopListRestController {

    @Autowired
    private ShopListService shopListService;

    @GetMapping("/shoplist")
    public List<ShopListDTO> findAll(){
        return shopListService.findAll();
    }

    @GetMapping("/shoplist/{shopListId}")
    public ShopListDTO getShopList(@PathVariable int shopListId){

        ShopListDTO theShopList = shopListService.findById(shopListId);

        if(theShopList == null){
            throw new RuntimeException("The product is not found - " + shopListId);
        }

        return theShopList;

    }
//
//    @PostMapping("/shoplist")
//    public ShopListDTO addShopList(@RequestBody ShopListDTO theShopList){
//
////        theShopList.setId(0);
//
//        ShopListDTO dbShopList = shopListService.save(theShopList);
//
//        return dbShopList;
//    }
//
//    @PutMapping("/shoplist")
//    public ShopListDTO updateShopList(@RequestBody ShopListDTO theShopList){
//
//        ShopListDTO dbShopList = shopListService.save(theShopList);
//        return dbShopList;
//
//    }
//
//    @DeleteMapping("/shoplist/{shopListId}")
//    public String deleteShopList(@PathVariable int shopListId) {
//
//        ShopListDTO tempShopList = shopListService.findById(shopListId);
//
//        if(tempShopList == null){
//            throw new RuntimeException("Product is not found - " + shopListId);
//        }
//
//        shopListService.deleteById(shopListId);
//        return "delete product id " + shopListId;
//    }

}
