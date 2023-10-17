package sdu.products_list.service;

import org.junit.jupiter.api.Test;
import sdu.products_list.dto.ProductsListDTO;
import sdu.products_list.entity.ProductsList;

import static org.junit.jupiter.api.Assertions.*;

class ProductsListServiceImplTest {

    @Test
    void findById() {
        var findID = new ProductsListDTO();
        assertNotNull(findID.getId());

    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}