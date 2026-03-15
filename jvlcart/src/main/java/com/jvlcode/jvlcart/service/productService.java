package com.jvlcode.jvlcart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jvlcode.jvlcart.DTO.ProductReviewDTO;
import com.jvlcode.jvlcart.DTO.productDTO;
import com.jvlcode.jvlcart.DTO.productImageDTO;
import com.jvlcode.jvlcart.entity.product;
import com.jvlcode.jvlcart.entity.productImage;
import com.jvlcode.jvlcart.entity.productReviews;
import com.jvlcode.jvlcart.repository.productRepository;
import com.jvlcode.jvlcart.repository.productReviewRepo;
import com.jvlcode.jvlcart.specification.ProductSpecification;


@Service
public class productService {
	
	@Autowired
	private productRepository productRepository;
	
	@Autowired
	private productReviewRepo productReviewRepo;
	
	public Map<String,Object> getAllProduct(int page,int size){
		Pageable pageable= PageRequest.of(page, size);
		
		Page<product> product = productRepository.findAll(pageable);
		
		List<productDTO> productDTOs= product.stream().map(this::ConvertToDto).collect(Collectors.toList());
		
		Map<String,Object> products=new HashMap<String, Object>();
		
//		products.put("products", product.getContent());
		products.put("products", productDTOs);
		products.put("TotalProducts", product.getTotalElements());
		products.put("total Page", product.getTotalPages());
		return products;
	}
	
	public productDTO ConvertToDto(product product) {
		
		productDTO productDTO = new productDTO();
		
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategory(product.getCategory());
		productDTO.setRating(product.getRating());
		productDTO.setSeller(product.getSeller());
		productDTO.setStock(product.getStock());
		productDTO.setNumOfReviews(product.getNumOfReviews());
		
		List<ProductReviewDTO> productReviewDTO = product.getReviews().stream().map(review ->{
				ProductReviewDTO reviewDTO = new ProductReviewDTO();
				reviewDTO.setRating(review.getRating());
				reviewDTO.setComment(review.getComment());
				reviewDTO.setProductid(review.getId());
				return reviewDTO;
		}).collect(Collectors.toList());
		productDTO.setReviews(productReviewDTO);
		//-------
		List<productImageDTO> images = product.getImages().stream().map(image -> 
		{
			productImageDTO imageDTO = new productImageDTO();
			
			imageDTO.setUrl(image.getUrl());
			
			return imageDTO;
		}).collect(Collectors.toList());
		productDTO.setImages(images);
		
		
		return productDTO;
	}
	
	 public product getProductByID(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not exits :"+id));
	}
	 
	 public List<product> SearchProduct(String category,Double minPrice,Double maxPrice,String Keyword,Double Rating) {
		
		 Specification<product> spec = Specification.where(ProductSpecification.hasCategory(category))
				.and(ProductSpecification.Price(minPrice, maxPrice))
				.and(ProductSpecification.getNameOrDescription(Keyword))
				.and(ProductSpecification.Rating(Rating));
		return productRepository.findAll(spec);
	}
// adding review
	 public void addReview(ProductReviewDTO reviewDTO) {
		
		product product = productRepository.findById(reviewDTO.getProductid()).orElseThrow(() -> new RuntimeException("Id Not Found"));
		
		productReviews productReviews=new productReviews();
		// need cleartity 
		
		productReviews.setProduct(product);
		productReviews.setRating(reviewDTO.getRating());
		productReviews.setComment(reviewDTO.getComment());
		
		productReviewRepo.save(productReviews);
	 }
}