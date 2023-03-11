package com.capitole.logandotest.controller;

import com.capitole.logandotest.api.controller.PriceMapper;
import com.capitole.logandotest.api.controller.dto.PriceResponseDto;
import com.capitole.logandotest.api.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Price Mapper Mapper")
public class PriceMapperTest {

    private PriceMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = PriceMapper.INSTANCE;
    }

    @Test
    void model_price_mapped_to_price_response_dto() {
        final var model = new Price();
        model.setPriceId(Long.MIN_VALUE);
        model.setBrandId(Long.MIN_VALUE);
        model.setStartDate(LocalDateTime.now());
        model.setEndDate(LocalDateTime.now());
        model.setPriceList(Integer.MIN_VALUE);
        model.setProductId(Long.MIN_VALUE);
        model.setPriority(Integer.MIN_VALUE);
        model.setPrice(Double.MIN_VALUE);
        model.setCurr("EUR");

        final PriceResponseDto dto = mapper.map(model);

        assertThat(dto)
                .isNotNull();

        assertThat(dto.getPrice())
                .isEqualTo(model.getPrice());

        assertThat(dto.getPriceList())
                .isEqualTo(model.getPriceList());

        assertThat(dto.getBrandId())
                .isEqualTo(model.getBrandId());

        assertThat(dto.getEndDate())
                .isEqualTo(model.getEndDate());

        assertThat(dto.getStartDate())
                .isEqualTo(model.getStartDate());

        assertThat(dto.getProductId())
                .isEqualTo(model.getProductId());

    }

}
