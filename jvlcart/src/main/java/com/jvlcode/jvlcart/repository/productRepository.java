package com.jvlcode.jvlcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jvlcode.jvlcart.entity.product;

@Repository
public interface productRepository extends JpaRepository<product, Long>,JpaSpecificationExecutor<product>{

}
