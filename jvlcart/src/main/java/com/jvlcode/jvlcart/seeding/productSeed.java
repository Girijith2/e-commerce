package com.jvlcode.jvlcart.seeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jvlcode.jvlcart.entity.product;
import com.jvlcode.jvlcart.entity.productImage;
import com.jvlcode.jvlcart.repository.productRepository;

@Component
public class productSeed implements CommandLineRunner{

	@Autowired
	private productRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {

		if(productRepository.count()==0) {
			List<product> product=List.of(
					new product(null, "Apple iPhone 15 Pro", 1299, "Latest Apple flagship phone","phone", 4.8, "Amazon", 25, 120,List.of("/products/1.webp")),
					new product(null, "iPhone 14", 799, "Reliable Apple smartphone with great performance", "Electronics", 4.6, "Amazon", 35, 160, List.of("/products/2.png")),
				    new product(null, "Samsung Galaxy S23 FE", 599, "Fan edition flagship experience","Electronics", 4.5, "Samsung Store", 40, 185, List.of("/products/3.webp")),
				    new product(null, "Lenovo IdeaPad Slim 5", 749, "Lightweight everyday performance laptop","Computers", 4.4, "Lenovo Store", 22, 90, List.of("/products/4.png")),
				    new product(null, "HP Victus Gaming Laptop", 1099, "Entry-level gaming performance machine","Computers", 4.5, "HP Store", 15, 70, List.of("/products/5.jpeg")),
				    new product(null, "Sony WF-1000XM5 Earbuds", 299, "Premium noise cancelling earbuds","Accessories", 4.7, "Sony Store", 60, 240, List.of("/products/6.jpg")),
				    new product(null, "Logitech G Pro Wireless Mouse", 129, "High precision gaming mouse","Accessories", 4.8, "Logitech", 80, 310, List.of("/products/7.png")),
				    new product(null, "Samsung 6.5kg Washing Machine", 499, "Efficient top load washing machine","Home Appliances", 4.3, "Samsung Store", 12, 55,List.of( "/products/8.jpg")),
				    new product(null, "LG 1.5 Ton Inverter AC", 899, "Energy saving split air conditioner","Home Appliances", 4.6, "LG Store", 10, 48, List.of("/products/9.jpg")),
				    new product(null, "Canon EOS R50 Camera", 899, "Compact mirrorless camera for creators","Electronics", 4.7, "Canon Store", 14, 62, List.of("/products/10.jpg")),
				    new product(null, "Boat Stone 620 Speaker", 59, "Portable Bluetooth party speaker","Accessories", 4.2, "Flipkart", 120, 420, List.of("/products/11.webp")));
			productRepository.saveAll(product); 
			System.out.println("seeded successfully");
		}	else {
			System.out.println("already product Exist! Skiping Seed");
		}
	}
}
