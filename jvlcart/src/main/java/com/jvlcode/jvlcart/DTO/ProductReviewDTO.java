package com.jvlcode.jvlcart.DTO;

import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDTO {
	@NotNull(message = "ID field is empty")
	private Long productid;
	@NotBlank(message = "message field is required")
	private String comment;
	
	private Double rating;
}
