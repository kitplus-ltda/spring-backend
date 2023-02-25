package br.com.kitplus.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ResumeOrderDTO {
    String orderId ;
    String orderDate;
    String user;
    String status;
    List<OrderItemDTO> items;
}
