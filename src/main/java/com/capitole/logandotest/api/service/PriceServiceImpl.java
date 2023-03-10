package com.capitole.logandotest.api.service;

import com.capitole.logandotest.api.model.Price;
import com.capitole.logandotest.api.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
class PriceServiceImpl implements PriceService {

    private PriceRepository repository;

    @Override
    public Optional<Price> get(Long productId, Long brandId, LocalDateTime date) {

        final var pricesList = repository.findPriceBy(productId, brandId, date);

        // PRIORITY: Desambiguador de aplicación de precios.
        // Si dos tarifas coinciden en un rango de
        // fechas se aplica la de mayor prioridad (mayor valor numérico).
         if (!pricesList.isEmpty()){
             //sorting applied in the query, see PriceRepository:findPriceBy
             return Optional.of(pricesList.get(0));
         }
         return Optional.empty();
    }
}
