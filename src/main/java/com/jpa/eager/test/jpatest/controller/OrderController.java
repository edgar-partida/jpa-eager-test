package com.jpa.eager.test.jpatest.controller;

import com.jpa.eager.test.jpatest.data.entity.AccessoryModel;
import com.jpa.eager.test.jpatest.data.entity.DeviceModel;
import com.jpa.eager.test.jpatest.data.entity.OrderDetailsModel;
import com.jpa.eager.test.jpatest.data.repo.OrderModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {


    private final OrderModelRepo repo;
    @GetMapping("/order")
    private OrderDetailsModel getOrder() {
        OrderDetailsModel order = OrderDetailsModel.builder()
                .mid("mid1")
                .trackingId("tracking1")
                .accesories(Set.of(AccessoryModel.builder().accessoryName("ACC1").build()))
                .devices(Set.of(DeviceModel.builder().deviceName("DEV1").build()))
                .build();
        repo.save(order);
        return order;
    }
}
