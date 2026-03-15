package com.jvlcode.jvlcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jvlcode.jvlcart.entity.product;
import com.jvlcode.jvlcart.entity.productReviews;

public interface productReviewRepo extends JpaRepository<productReviews, Long>{

}
