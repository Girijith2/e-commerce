package com.jvlcode.jvlcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.jvlcode.jvlcart.entity.order;

public interface orderRepository extends JpaRepository<order, Long>{
	Optional<order> findByorderNo(String reference);
}
