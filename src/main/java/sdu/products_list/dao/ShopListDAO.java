package sdu.products_list.dao;

import org.hibernate.exception.SQLGrammarException;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.entity.ShopList;

import java.util.List;


public interface ShopListDAO {

    List<ShopList> findAllShopList() ;

    ShopList findById(int theId) throws Exception;

    ShopList save(ShopList theShopList) ;

    void deleteById(int theId) ;

}
