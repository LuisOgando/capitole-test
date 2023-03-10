package com.capitole.logandotest.api.controller;

import com.capitole.logandotest.api.model.Price;
import com.capitole.logandotest.api.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PriceController {
    private PriceService service;

    @GetMapping("/price")
    public List<Price> findAllPrice(){
        return service.findAllPrices();
    }
}
