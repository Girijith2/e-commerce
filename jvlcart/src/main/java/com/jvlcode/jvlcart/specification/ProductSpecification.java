 package com.jvlcode.jvlcart.specification;

import org.springframework.data.jpa.domain.Specification;

import com.jvlcode.jvlcart.entity.product;

public class ProductSpecification {

	public static Specification<product> hasCategory(String category) {
		return (root,query,cb)-> category == null? cb.conjunction(): cb.equal(root.get("category"), category);
	}
	
	public static Specification<product> Price(Double min, Double max) {
		return (root,query,cb)-> {
			if(min==null && max == null) return cb.conjunction();
			if(min == null) return cb.lessThanOrEqualTo(root.get("price"), max);
			if(max == null) return cb.greaterThanOrEqualTo(root.get("price"), min);
			return cb.between(root.get("price"), min, max);
		};
	}
	
	public static Specification<product> getNameOrDescription(String keyword) {
		return (root,query,cb) -> {
			if(keyword==null || keyword.isEmpty()) return cb.conjunction();
			return cb.or(
					cb.like(root.get("name"), "%"+keyword.toLowerCase()+"%"),
					cb.like(root.get("Description"), "%"+keyword.toLowerCase()+"%"));
		};
	}
	public static Specification<product> Rating(Double Rating) {
		return (root,query,cb)-> {
			if(Rating == null) return cb.conjunction();
			return cb.greaterThanOrEqualTo(root.get("Rating"), Rating);
		};
	}
}