package com.capitole.logandotest.controller;

import com.capitole.logandotest.api.controller.PriceController;
import com.capitole.logandotest.api.model.Price;
import com.capitole.logandotest.api.service.PriceService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@DisplayName("Price Controller Test")
public class PriceControllerTest {
    @Mock
    private PriceService mockService;
    private String baseUri;
    private MockMvc mockMvc;
    private EasyRandom randomGeneration;

    @BeforeEach
    public void setUp() {
        randomGeneration = new EasyRandom();

        final var requestMappingAnnotation = PriceController.class.
                getDeclaredAnnotation(RequestMapping.class);

        baseUri = requestMappingAnnotation.value()[0];
        final var controller = new PriceController(mockService);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Nested
    @DisplayName("getPriceBy() Tests")
    class GetPriceByTest {

        //-Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        @Test
        void get_price_at_1000_day_14_product_35455_brand_1_should_return_http_status_200() throws Throwable {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T00:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);
            final var fakePrice = randomGeneration.nextObject(Price.class);

            final var getUri = String.format("%s?product_id=%d&brand_id=%d&date=%s",
                    baseUri, fakeProductId, fakeBrandId, fakeRequestDateStr
            );
            when(mockService.get(fakeProductId, fakeBrandId, fakeRequestDate))
                    .thenReturn(Optional.of(fakePrice));

            mockMvc
                    .perform(get(getUri))
                    .andExpect(status().isOk());
        }

    }

    //-Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void get_price_at_1600_day_14_product_35455_brand_1_should_return_http_status_200() throws Throwable {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-14T16:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);
        final var fakePrice = randomGeneration.nextObject(Price.class);

        final var getUri = String.format("%s?product_id=%d&brand_id=%d&date=%s",
                baseUri, fakeProductId, fakeBrandId, fakeRequestDateStr
        );
        when(mockService.get(fakeProductId, fakeBrandId, fakeRequestDate))
                .thenReturn(Optional.of(fakePrice));

        mockMvc
                .perform(get(getUri))
                .andExpect(status().isOk());
    }

    //-Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void get_price_at_2100_day_14_product_35455_brand_1_should_return_http_status_200() throws Throwable {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-14T21:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);
        final var fakePrice = randomGeneration.nextObject(Price.class);

        final var getUri = String.format("%s?product_id=%d&brand_id=%d&date=%s",
                baseUri, fakeProductId, fakeBrandId, fakeRequestDateStr
        );
        when(mockService.get(fakeProductId, fakeBrandId, fakeRequestDate))
                .thenReturn(Optional.of(fakePrice));

        mockMvc
                .perform(get(getUri))
                .andExpect(status().isOk());
    }

    //-Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    void get_price_at_1000_day_15_product_35455_brand_1_should_return_http_status_200() throws Throwable {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-15T21:10:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);
        final var fakePrice = randomGeneration.nextObject(Price.class);

        final var getUri = String.format("%s?product_id=%d&brand_id=%d&date=%s",
                baseUri, fakeProductId, fakeBrandId, fakeRequestDateStr
        );
        when(mockService.get(fakeProductId, fakeBrandId, fakeRequestDate))
                .thenReturn(Optional.of(fakePrice));

        mockMvc
                .perform(get(getUri))
                .andExpect(status().isOk());
    }

    //-Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    void get_price_at_2100_day_16_product_35455_brand_1_should_return_http_status_200() throws Throwable {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-16T21:10:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);
        final var fakePrice = randomGeneration.nextObject(Price.class);

        final var getUri = String.format("%s?product_id=%d&brand_id=%d&date=%s",
                baseUri, fakeProductId, fakeBrandId, fakeRequestDateStr
        );
        when(mockService.get(fakeProductId, fakeBrandId, fakeRequestDate))
                .thenReturn(Optional.of(fakePrice));

        mockMvc
                .perform(get(getUri))
                .andExpect(status().isOk());
    }

    @Test
    void get_price_should_return_http_status_404_not_found() throws Throwable {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-16T21:10:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        final var getUri = String.format("%s?product_id=%d&brand_id=%d&date=%s",
                baseUri, fakeProductId, fakeBrandId, fakeRequestDateStr
        );
        when(mockService.get(fakeProductId, fakeBrandId, fakeRequestDate))
                .thenReturn(Optional.empty());

        mockMvc
                .perform(get(getUri))
                .andExpect(status().isNotFound());
    }

    @Test
    void get_price_should_return_http_status_400_bad_resquest() throws Throwable {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;

        final var getUri = String.format("%s?product_id=%d&brand_id=%d",
                baseUri, fakeProductId, fakeBrandId
        );
        mockMvc
                .perform(get(getUri))
                .andExpect(status().isBadRequest());
    }


}
