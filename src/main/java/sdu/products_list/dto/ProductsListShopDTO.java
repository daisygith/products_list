package sdu.products_list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sdu.products_list.entity.ProductsList;
import sdu.products_list.entity.ShopList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsListShopDTO {

    private int id;

    private float qty;

    private int productsListId;

    private String productsListName;

    private String productsListUnit;
    
}
