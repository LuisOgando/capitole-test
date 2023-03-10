package com.capitole.logandotest.api.service;

import com.capitole.logandotest.api.model.Price;
import com.capitole.logandotest.api.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PriceService {
    private PriceRepository repository;

    public List<Price> findAllPrices(){
        return repository.findAll();
    }
}
