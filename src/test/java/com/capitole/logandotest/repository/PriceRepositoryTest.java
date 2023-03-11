package com.capitole.logandotest.repository;

import com.capitole.logandotest.api.repository.PriceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Price Repository Test")
public class PriceRepositoryTest {

    @Autowired
    private PriceRepository repository;

    @Nested
    @DisplayName("findPriceBy() Tests")
    class GetPriceByTest {

        //-Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        @Test
        void find_price_by_at_1000_day_14_product_35455_brand_1_should_return_a_prices_list() {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T10:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

            var prices = repository.findPriceBy(fakeProductId, fakeBrandId, fakeRequestDate);
            assertThat(prices).isNotNull();
            assertThat(prices.get(0)).isNotNull();
            assertThat(prices.isEmpty()).isFalse();
            assertThat(prices.size()).isGreaterThan(0);

        }

        //-Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        @Test
        void find_price_by_at_1600_day_14_product_35455_brand_1_should_return_a_prices_list() {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T16:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

            var prices = repository.findPriceBy(fakeProductId, fakeBrandId, fakeRequestDate);
            assertThat(prices).isNotNull();
            assertThat(prices.get(0)).isNotNull();
            assertThat(prices.isEmpty()).isFalse();
            assertThat(prices.size()).isGreaterThan(0);

        }

        //-Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        @Test
        void find_price_by_at_2100_day_14_product_35455_brand_1_should_return_a_prices_list() {
            final var fakeProductId = 35455L;
            final var fakeBrandId = 1L;
            final var fakeRequestDateStr = "2020-06-14T21:00:00.000";
            final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

            var prices = repository.findPriceBy(fakeProductId, fakeBrandId, fakeRequestDate);
            assertThat(prices).isNotNull();
            assertThat(prices.get(0)).isNotNull();
            assertThat(prices.isEmpty()).isFalse();
            assertThat(prices.size()).isGreaterThan(0);
        }
    }

    //-Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    void find_price_by_at_1000_day_15_product_35455_brand_1_should_return_a_prices_list() {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-15T10:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        var prices = repository.findPriceBy(fakeProductId, fakeBrandId, fakeRequestDate);
        assertThat(prices).isNotNull();
        assertThat(prices.get(0)).isNotNull();
        assertThat(prices.isEmpty()).isFalse();
        assertThat(prices.size()).isGreaterThan(0);
    }

    //-Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    void find_price_by_at_2100_day_16_product_35455_brand_1_should_return_a_prices_list() {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 1L;
        final var fakeRequestDateStr = "2020-06-16T21:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        var prices = repository.findPriceBy(fakeProductId, fakeBrandId, fakeRequestDate);
        assertThat(prices).isNotNull();
        assertThat(prices.get(0)).isNotNull();
        assertThat(prices.isEmpty()).isFalse();
        assertThat(prices.size()).isGreaterThan(0);
    }

    @Test
    void find_price_by_should_return_an_empty_list()  {
        final var fakeProductId = 35455L;
        final var fakeBrandId = 2L;
        final var fakeRequestDateStr = "2020-06-16T21:00:00.000";
        final var fakeRequestDate = LocalDateTime.parse(fakeRequestDateStr);

        var prices = repository.findPriceBy(fakeProductId, fakeBrandId, fakeRequestDate);
        assertThat(prices).isNotNull();
        assertThat(prices.isEmpty()).isTrue();
        assertThat(prices.size()).isEqualTo(0);
    }

}
