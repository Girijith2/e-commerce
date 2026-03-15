package com.jvlcode.jvlcart.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderItemDTO {
	
	private String name;
	private Integer qunaity;
	private String image;
	private Integer price;
	
	private Long productId;
}
