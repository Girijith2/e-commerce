package com.jvlcode.jvlcart.service;

import java.util.UUID;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvlcode.jvlcart.DTO.CreateOrderRequest;
import com.jvlcode.jvlcart.DTO.orderCreated;
import com.jvlcode.jvlcart.DTO.orderItemDTO;
import com.jvlcode.jvlcart.entity.order;
import com.jvlcode.jvlcart.entity.orderItem;
import com.jvlcode.jvlcart.entity.product;
import com.jvlcode.jvlcart.repository.orderRepository;
import com.jvlcode.jvlcart.repository.productRepository;

@Service
public class orderService {

	@Autowired
	private productRepository repository;
	
	@Autowired
	private orderRepository orderRepo;
	
	order order = new order();
	Integer totalItemPrice=0;
	Integer TotalTax = 10;
	Integer totalAll = 0;
	String status = "PENDING";
	public orderCreated createOrder(CreateOrderRequest CreateOrderRequest) {
		
		for(orderItemDTO item : CreateOrderRequest.getOrderitemDTO()) {
			orderItem orderItem = new orderItem();
			
			orderItem.setName(item.getName());
			orderItem.setImage(item.getImage());
			orderItem.setPrice(item.getPrice());
			orderItem.setQunaity(item.getQunaity());
			
			product product = repository.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("product Not Found"));
			orderItem.setProduct(product);
			
			order.getOrder().add(orderItem);
			totalItemPrice += item.getQunaity() * item.getPrice();
		}
		order.setStatus(status);
		order.setTotalTax(TotalTax);
		String refId = UUID.randomUUID().toString();
		order.setOrderNo(refId);
		
		totalAll = totalItemPrice+TotalTax;
		order.setTotalItemPrice(totalItemPrice);
		order.setTotalAll(totalAll);
		
		orderRepo.save(order);
		
		return new orderCreated(refId);
	}

	public order getOrderDetails(String reference) {
		
		return orderRepo.findByorderNo(reference).orElseThrow(()-> new RuntimeException("referenceId not found"));
		
	}
}
