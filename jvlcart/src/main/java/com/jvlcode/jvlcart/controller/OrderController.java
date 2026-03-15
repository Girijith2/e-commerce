package com.jvlcode.jvlcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jvlcode.jvlcart.DTO.CreateOrderRequest;
import com.jvlcode.jvlcart.repository.orderRepository;
import com.jvlcode.jvlcart.service.orderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private orderService orderService;
	
	@Autowired
	private orderRepository orderRepository;
	
	@PostMapping("/order")
	public ResponseEntity<?> orders(@RequestBody CreateOrderRequest request) {
		
		return ResponseEntity.ok().body(orderService.createOrder(request));
	}
	
	@GetMapping("/order/{reference}")
	public ResponseEntity<?> getOrder(@PathVariable String reference){
		 return ResponseEntity.ok().body(orderService.getOrderDetails(reference));
	}
}
