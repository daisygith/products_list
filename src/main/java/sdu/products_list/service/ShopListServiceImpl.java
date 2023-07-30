package sdu.products_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.products_list.dao.ShopListDAO;
import sdu.products_list.dto.ShopListDTO;
import sdu.products_list.entity.ShopList;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopListServiceImpl implements ShopListService{

    @Autowired
    private ShopListDAO shopListDAO;

    @Override
    public List<ShopListDTO> findAll() {
        // lista z wszystkimi elementami bazy danych
       List<ShopList> list = shopListDAO.findAllShopList();
       // utworzenie pustej listy DTO
       List<ShopListDTO> listDTO = new ArrayList<>();
        // przepisanie wartości z encji do obiektów dto
       list.forEach((ShopList item) -> {
           listDTO.add(new ShopListDTO(item.getId(),item.getName()));
       });
        // zwracanie listy DTO
       return listDTO;
    }

    @Override
    public ShopListDTO findById(int theId) {

        ShopList product = shopListDAO.findById(theId);

        ShopListDTO productDTO = new ShopListDTO(product.getId(), product.getName());

        return productDTO;

    }


    @Transactional
    @Override
    public ShopListDTO save(ShopListDTO theShopListDTO) {
        // dla merge
        ShopList product = shopListDAO.save(new ShopList(theShopListDTO.getId(), theShopListDTO.getName()));
        // dla persist + trzebaby było rozbić na save i update
        //ShopList product = new ShopList(theShopListDTO.getId(), theShopListDTO.getName());
        //shopListDAO.save(product);

        ShopListDTO productDTO = new ShopListDTO(product.getId(), product.getName());

        return productDTO;
        //return shopListDAO.save(theShopList);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        shopListDAO.deleteById(theId);

    }


}
