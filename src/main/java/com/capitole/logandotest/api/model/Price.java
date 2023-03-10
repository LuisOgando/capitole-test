package com.capitole.logandotest.api.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;


@Entity
@Table(name = "price")
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long priceId;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "Price")
    private Double price;

    @Column(name = "curr")
    private String curr;

}
