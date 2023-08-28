package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ShopListDAO;
import sdu.products_list.dto.RecipesListDTO;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.entity.RecipesList;
import sdu.products_list.entity.ShopList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopListServiceImpl implements ShopListService{

    @Autowired
    private ShopListDAO shopListDAO;

    @Override
    public List<ShopListDTO> findAll() {
        // lista z wszystkimi elementami bazy danych
       List<ShopList> shopList = shopListDAO.findAllShopList();
       // utworzenie pustej listy DTO
       List<ShopListDTO> shopListDTO = new ArrayList<>();
        // przepisanie wartości z encji do obiektów dto
        // modifikacja na builder / ponieważ doszło List<RecipesListShopDTO
       shopList.forEach((ShopList item) -> {
           shopListDTO.add(ShopListDTO.builder()
                   .id(item.getId())
                   .name(item.getName())
                   .build());
       });
        // zwracanie listy DTO
       return shopListDTO;
    }

    @Override
    public ShopListDTO findById(int theId) {

        ShopList productShopList = shopListDAO.findById(theId);

        ShopListDTO productShopListDTO = ShopListDTO.builder()
                .id(productShopList.getId())
                .name(productShopList.getName())
//                .recipesListSet(productShopList.getRecipesListSet().stream()
//                        .map(x-> RecipesListDTO.builder()
//                                .id(x.getId())
//                                .name(x.getName())
//                                .build()).collect(Collectors.toList()))
                .build();


        //ShopListDTO productDTO = new ShopListDTO(product.getId(), product.getName());

        return productShopListDTO;

    }


    @Transactional
    @Override
    public ShopListDTO save(ShopListDTO theShopListDTO) {

        // dla merge
        //ShopList product = shopListDAO.save(new ShopList(theShopListDTO.getId(), theShopListDTO.getName()));
        // dla persist + trzebaby było rozbić na save i update
        //ShopList product = new ShopList(theShopListDTO.getId(), theShopListDTO.getName());
        //shopListDAO.save(product);
        ShopList productList = shopListDAO.save(ShopList.builder()
                        .id(theShopListDTO.getId())
                        .name(theShopListDTO.getName())
                        .recipesList(theShopListDTO.getRecipesList() != null ? theShopListDTO.getRecipesList().stream()
                .map(x-> RecipesList.builder()
                        .id(x.getId()).name(x.getName())
                        .build()).collect(Collectors.toList()) : null)
         .build());

        ShopListDTO productListDTO = ShopListDTO.builder()
                .id(productList.getId())
                .name(productList.getName())
                .build();

        if(productList.getRecipesList() != null) {
            productListDTO.setRecipesList(productList.getRecipesList().stream()
                    .map(x->RecipesListDTO.builder()
                            .id(x.getId()).name(x.getName())
                            .build()).collect(Collectors.toList()));
        }

        return productListDTO;
        //return shopListDAO.save(theShopList);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        shopListDAO.deleteById(theId);

    }


}
