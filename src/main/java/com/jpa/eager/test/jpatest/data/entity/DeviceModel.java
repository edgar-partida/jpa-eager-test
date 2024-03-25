package com.jpa.eager.test.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "DEVICE")
public class DeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;

    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetailsModel orderDetails;

    // Getters and Setters
}

