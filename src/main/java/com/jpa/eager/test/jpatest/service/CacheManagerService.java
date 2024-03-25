package com.jpa.eager.test.jpatest.service;

import com.jpa.eager.test.jpatest.data.entity.OrderDetailsModel;
import com.jpa.eager.test.jpatest.data.repo.OrderModelRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class CacheManagerService {

    private final OrderModelRepo orderRepo;

    private Map<String, List<OrderDetailsModel>> mapCache = new ConcurrentHashMap<>();

    @PostConstruct
    private void loadCache() {
        log.info("Reading all orders");
        List<OrderDetailsModel> orders = orderRepo.findAll();
        log.info("Found {} orders on database", orders.size());
        orders.forEach(order -> {
            mapCache.computeIfAbsent(order.getMid(), k -> new ArrayList<>()).add(order);
        });
    }
}
