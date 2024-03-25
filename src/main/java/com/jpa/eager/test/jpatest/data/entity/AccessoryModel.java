package com.jpa.eager.test.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="ACCESSORY")
public class AccessoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accessoryName;

    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetailsModel orderDetails;

    // Getters and Setters
}
