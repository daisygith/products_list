package sdu.products_list.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
