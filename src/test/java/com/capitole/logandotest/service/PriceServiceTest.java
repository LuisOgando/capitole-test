package com.capitole.logandotest.service;

import com.capitole.logandotest.api.service.PriceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Price Service Test")
public class PriceServiceTest {

    @Autowired
    private PriceService service;

    @Nested
    @DisplayName("get() Tests")
    class GetTest {

        //-Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        @Test
        void get_at_1000_day_14_product_35455_brand_1_should_return_a_prices_optional() {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T10:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

            var prices = service.get(fakeProductId, fakeBrandId, fakeRequestDate);
            assertThat(prices).isNotNull();
            assertThat(prices.get()).isNotNull();
            assertThat(prices.isEmpty()).isFalse();
            assertThat(prices.isPresent()).isTrue();

        }

        //-Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        @Test
        void get_at_1600_day_14_product_35455_brand_1_should_return_a_prices_optional() {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T16:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

            var prices = service.get(fakeProductId, fakeBrandId, fakeRequestDate);
            assertThat(prices).isNotNull();
            assertThat(prices.get()).isNotNull();
            assertThat(prices.isEmpty()).isFalse();
            assertThat(prices.isPresent()).isTrue();

        }

        //-Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        @Test
        void get_at_2100_day_14_product_35455_brand_1_should_return_a_prices_optional() {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T21:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

            var prices = service.get(fakeProductId, fakeBrandId, fakeRequestDate);
            assertThat(prices).isNotNull();
            assertThat(prices.get()).isNotNull();
            assertThat(prices.isEmpty()).isFalse();
            assertThat(prices.isPresent()).isTrue();
        }
    }

    //-Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    void get_at_1000_day_15_product_35455_brand_1_should_return_a_prices_optional() {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-15T10:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        var prices = service.get(fakeProductId, fakeBrandId, fakeRequestDate);
        assertThat(prices).isNotNull();
        assertThat(prices.get()).isNotNull();
        assertThat(prices.isEmpty()).isFalse();
        assertThat(prices.isPresent()).isTrue();
    }

    //-Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    void get_at_2100_day_16_product_35455_brand_1_should_return_a_prices_optional() {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-16T21:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        var prices = service.get(fakeProductId, fakeBrandId, fakeRequestDate);
        assertThat(prices).isNotNull();
        assertThat(prices.get()).isNotNull();
        assertThat(prices.isEmpty()).isFalse();
        assertThat(prices.isPresent()).isTrue();
    }

    @Test
    void get_should_return_an_empty_optional()  {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 2L;
        final var fakeRequestDateStr = "2020-06-16T21:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        var prices = service.get(fakeProductId, fakeBrandId, fakeRequestDate);
        assertThat(prices).isNotNull();
        assertThat(prices.isEmpty()).isTrue();
        assertThat(prices.isPresent()).isFalse();
    }
}
