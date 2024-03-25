package com.jpa.eager.test.jpatest.data.repo;

import com.jpa.eager.test.jpatest.data.entity.OrderDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderModelRepo extends JpaRepository<OrderDetailsModel, Long> {

}
