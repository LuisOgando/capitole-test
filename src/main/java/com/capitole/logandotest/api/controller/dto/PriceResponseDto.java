package com.capitole.logandotest.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceResponseDto {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("price_list")
    private Integer priceList;

    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @JsonProperty("end_date")
    private LocalDateTime endDate;

    @JsonProperty("price")
    private Double price;
}
