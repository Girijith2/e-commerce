package com.jvlcode.jvlcart.entity;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "Products")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "username field is required")
	private String name;
	
	@Column(nullable = false)
	@NotNull(message = "price field is required")
	@PositiveOrZero
	private Integer price;
	
	@NotBlank(message = "Description field is required")
	private String Description;
	
	private String category;
	
	@Min( value = 1)
	@Max(value = 5)
	private Double Rating;
	
	@NotBlank(message = "seller field is required")
	private String seller;
	
	@NotNull(message = "stock field is required")
	private Integer stock;
	
	private Integer numOfReviews;
	
	
	public product(Long id,String name,Integer price,String description, String category,Double rating,String seller,Integer stock, Integer numOfReviews,List<String> images) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.Description = description;
		this.category = category;
		this.Rating = rating;
		this.seller = seller;
		this.stock = stock;
		this.numOfReviews = numOfReviews;
		this.images = images.stream().map(url -> new productImage(url, this)).collect(Collectors.toList());
	}


	@JoinColumn(name = "product_id")
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	private List<productImage> images;

	@JoinColumn(name = "product_id")
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	private List<productReviews> reviews;
	
}