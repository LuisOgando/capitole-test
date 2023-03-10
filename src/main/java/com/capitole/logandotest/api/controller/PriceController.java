package com.capitole.logandotest.api.controller;

import com.capitole.logandotest.api.controller.dto.PriceResponseDto;
import com.capitole.logandotest.api.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
@AllArgsConstructor
public class PriceController {
    private final PriceService service;

    @GetMapping()
    private ResponseEntity<PriceResponseDto> findPriceBy(
            Long productId,
            Long brandId,
            LocalDateTime requestDate
    ) {
        final var optPrice = service.get(productId, brandId, requestDate);
        if (optPrice.isPresent()){
            var price = optPrice.get();
            return ResponseEntity.ok(PriceMapper.INSTANCE.map(price));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
