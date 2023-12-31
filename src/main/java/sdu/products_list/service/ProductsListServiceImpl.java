package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.dto.ProductsListRecipeDTO;
import sdu.products_list.dto.ProductsListShopDTO;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ProductsListRecipe;
import sdu.products_list.entity.ProductsListShop;
import sdu.products_list.exception.ElementNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsListServiceImpl implements ProductsListService{

    @Autowired
    private ProductsListDAO productsListDAO;


    @Override
    public List<ProductsListDTO> findAllProducts(){
        //pobieramy liste ze wszystkimi danymi z bazy danych
        List<ProductsList> productsList = productsListDAO.findAllProducts();
        //tworzenie pustej listy
        List<ProductsListDTO> productsListDTO = new ArrayList<>();

        productsList.forEach((ProductsList item) -> {
            productsListDTO.add(ProductsListDTO.builder()
                            .id(item.getId())
                            .name(item.getName())
                            .unit(item.getUnit())
                    .build());
        });

        return productsListDTO;
    }

    @Override
    public ProductsListDTO findById(int theId) throws Exception{

            ProductsList productList = productsListDAO.findById(theId).orElseThrow(()
                    -> new ElementNotFoundException(theId, "Product"));

            ProductsListDTO productListDTO = ProductsListDTO.builder()
                    .id(productList.getId())
                    .name(productList.getName())
                    .unit(productList.getUnit())
                    .productsListRecipe(productList.getProductsListRecipes().stream()
                            .map(x -> ProductsListRecipeDTO.builder()
                                    .id(x.getId())
                                    .qty(x.getQty())
                                    .build()).collect(Collectors.toList()))
                    .productsListShop(productList.getProductsListShop().stream()
                            .map(x -> ProductsListShopDTO.builder()
                                    .id(x.getId())
                                    .qty(x.getQty())
                                    .build()).collect(Collectors.toList()))
                    .build();

            return productListDTO;

    }

    @Transactional
    @Override
    public ProductsListDTO save(ProductsListDTO theProductsDTO) {

        ProductsList productList = productsListDAO.save(ProductsList.builder()
                        .id(theProductsDTO.getId())
                        .name(theProductsDTO.getName())
                        .unit(theProductsDTO.getUnit())
                        .productsListRecipes(theProductsDTO.getProductsListRecipe() != null ? theProductsDTO.getProductsListRecipe().stream()
                                .map(x-> ProductsListRecipe.builder()
                                        .id(x.getId())
                                        .qty(x.getQty())
                                        .build()).collect(Collectors.toList()): null)
                        .productsListShop(theProductsDTO.getProductsListShop() != null ? theProductsDTO.getProductsListShop().stream()
                                .map(x->ProductsListShop.builder()
                                        .id(x.getId())
                                        .qty(x.getQty())
                                        .build()).collect(Collectors.toList()) : null)
                .build());

        ProductsListDTO productListDTO = ProductsListDTO.builder()
                .id(productList.getId())
                .name(productList.getName())
                .unit(productList.getUnit())
                .build();

        if(productList.getProductsListRecipes() != null){
            productListDTO.setProductsListRecipe(productList.getProductsListRecipes().stream()
                    .map(x->ProductsListRecipeDTO.builder()
                            .id(x.getId())
                            .qty(x.getQty())
                            .build()).collect(Collectors.toList()));
        }

        if(productList.getProductsListShop() != null){
            productListDTO.setProductsListShop(productList.getProductsListShop().stream()
                    .map(x->ProductsListShopDTO.builder()
                            .id(x.getId())
                            .qty(x.getQty())
                            .build()).collect(Collectors.toList()));
        }

        return productListDTO;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
         productsListDAO.deleteById(theId);
    }
}
