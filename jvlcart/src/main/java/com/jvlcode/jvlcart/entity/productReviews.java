package com.jvlcode.jvlcart.entity;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProductReview")
public class productReviews {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	@Min(value = 1)
	@Max(value = 5)
	private Double Rating;
	private String comment;
	
	//need cleartity
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private product product;
	
}
