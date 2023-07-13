package sdu.products_list.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.service.ProductsListService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsListRestController {

    @Autowired
    private ProductsListService productsListService;


    @GetMapping("/productslist")
    public List<ProductsList> findAllProducts(){
        return productsListService.findAllProducts();
    }

    @GetMapping("/productslist/{productslistId}")
    public ProductsList getProductsList(@PathVariable int productslistId){
        ProductsList theProductsList = productsListService.findById(productslistId);

        if(theProductsList == null){
            throw new RuntimeException("Products List id not found" + productslistId);
        }
        return theProductsList;

    }

    @PostMapping("/productslist")
    public ProductsList addProducts(@RequestBody ProductsList theProducts){

        theProducts.setId(0);

        ProductsList dbProducts = productsListService.save(theProducts);

        return dbProducts;
    }

    @PutMapping("/productslist")
    public ProductsList updateProducts(@RequestBody ProductsList theProducts){

        ProductsList dbProducts = productsListService.save(theProducts);

        return dbProducts;

    }

}
