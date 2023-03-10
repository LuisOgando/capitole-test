package com.capitole.logandotest.api.controller;

import com.capitole.logandotest.api.controller.dto.PriceResponseDto;
import com.capitole.logandotest.api.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    PriceResponseDto map(Price from);
}
