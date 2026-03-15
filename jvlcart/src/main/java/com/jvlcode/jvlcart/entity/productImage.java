package com.jvlcode.jvlcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProductImage")
public class productImage {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String publicId;
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private product product;
	
	public productImage(String url, product product) {
		this.url=url;
		this.publicId=url;
		this.product=product;
	}
}
