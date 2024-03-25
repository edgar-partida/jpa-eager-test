package com.jpa.eager.test.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_DETAILS")
public class OrderDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mid;
    private String trackingId;
    private String orderNumber;
    @OneToMany(mappedBy = "orderDetails", cascade=CascadeType.ALL)
    private Set<AccessoryModel> accesories;

    @OneToMany(mappedBy = "orderDetails", cascade=CascadeType.ALL)
    private Set<DeviceModel> devices;
}

