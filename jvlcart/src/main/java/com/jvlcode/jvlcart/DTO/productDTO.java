package com.jvlcode.jvlcart.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvlcode.jvlcart.entity.productImage;
import com.jvlcode.jvlcart.entity.productReviews;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDTO {

	private Long id;
	private String name;
	private Integer price;
	private String Description;	
	private String category;
	private Double Rating;
	private String seller;
	private Integer stock;
	private Integer numOfReviews;

	private List<productImageDTO> images;
	private List<ProductReviewDTO> reviews;
	
}
