package com.jvlcode.jvlcart.DTO;

import java.util.List;

public class CreateOrderRequest {

    private List<orderItemDTO> orderitemDTO;

    public List<orderItemDTO> getOrderitemDTO() {
        return orderitemDTO;
    }

    public void setOrderitemDTO(List<orderItemDTO> orderitemDTO) {
        this.orderitemDTO = orderitemDTO;
    }
}
