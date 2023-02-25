package br.com.kitplus.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@ApiModel
public class OrderItemDTO {
    int productId;
    String name;
    int amount;
    String description;
    String price;
    String category;
    int height;
    int length;
    int width;


}
