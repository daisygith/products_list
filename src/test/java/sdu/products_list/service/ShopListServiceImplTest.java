package sdu.products_list.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sdu.products_list.dao.ShopListDAO;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ShopListServiceImplTest {
    @Mock
    private ShopListDAO shopListDAO;

    @InjectMocks
    private ShopListServiceImpl shopListService;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}