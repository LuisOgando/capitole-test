package com.capitole.logandotest.api.service;

import com.capitole.logandotest.api.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
    Optional<Price> get(
            Long productId,
            Long brandId,
            LocalDateTime requestDate
    );
}
