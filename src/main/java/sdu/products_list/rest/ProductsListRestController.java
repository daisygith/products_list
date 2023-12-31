package sdu.products_list.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.service.ProductsListService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsListRestController {

    @Autowired
    private ProductsListService productsListService;


    @GetMapping("/productslist")
    public List<ProductsListDTO> findAllProducts(){

        return productsListService.findAllProducts();
    }

    @GetMapping("/productslist/{productslistId}")
    public ProductsListDTO getProductsList(@PathVariable int productslistId) throws Exception {

        ProductsListDTO theProductsList = productsListService.findById(productslistId);

        return theProductsList;

    }

    @PostMapping("/productslist")
    public ProductsListDTO addProducts(@RequestBody ProductsListDTO theProductsDTO){

        theProductsDTO.setId(0);

        ProductsListDTO dbProducts = productsListService.save(theProductsDTO);

        return dbProducts;
    }

    @PutMapping("/productslist")
    public ProductsListDTO updateProducts(@RequestBody ProductsListDTO theProductsDTO){

        ProductsListDTO dbProducts = productsListService.save(theProductsDTO);

        return dbProducts;

    }

    @DeleteMapping("/productslist/{productslistId}")
    public String deleteProducts(@PathVariable int productslistId) throws Exception{

        ProductsListDTO tempProducts = productsListService.findById(productslistId);

        if(tempProducts == null){
            throw new RuntimeException("Product is not found - " + productslistId);
        }

        productsListService.deleteById(productslistId);

        return "Delete products id - " + productslistId;
    }

}
