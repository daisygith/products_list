package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ProductsListDAO;
import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.dto.ProductsListRecipeDTO;
import sdu.products_list.entity.ProductsList;

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
    public ProductsListDTO findById(int theId) {

        ProductsList productList = productsListDAO.findById(theId);

        //ProductsListDTO productListDTO = new ProductsListDTO(productList.getId(), productList.getName(), productList.getUnit());
        ProductsListDTO productListDTO = ProductsListDTO.builder()
                .id(productList.getId())
                .name(productList.getName())
                .unit(productList.getUnit())
                .productsListRecipe(productList.getProductsListRecipes().stream()
                        .map(x-> ProductsListRecipeDTO.builder()
                                .id(x.getId())
                                .qty(x.getQty())
                                .build()).collect(Collectors.toList()))
                .build();

        return productListDTO;
    }

//    @Transactional
//    @Override
//    public ProductsListDTO save(ProductsListDTO theProductsDTO) {
//
//        ProductsList productList = productsListDAO.save(new ProductsList(theProductsDTO.getId(), theProductsDTO.getName(), theProductsDTO.getUnit()));
//
//        ProductsListDTO productListDTO = new ProductsListDTO(productList.getId(), productList.getName(), productList.getUnit());
//
//        return productListDTO;
//    }
//
//    @Transactional
//    @Override
//    public void deleteById(int theId) {
//         productsListDAO.deleteById(theId);
//    }
}
