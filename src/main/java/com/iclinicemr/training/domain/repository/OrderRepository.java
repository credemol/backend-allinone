package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

//    @Query("")
//    List<Order> getOrderWithTotalPrice();

}
