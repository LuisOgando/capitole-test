package com.capitole.logandotest.api.repository;

import com.capitole.logandotest.api.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT P " +
            "FROM Price P " +
            "WHERE P.productId = :productId " +
            "AND P.brandId = :brandId " +
            "AND :requestDate BETWEEN P.startDate AND P.endDate " +
            "ORDER BY P.priority DESC ")
    List<Price> findPriceBy(
            Long productId,
            Long brandId,
            LocalDateTime requestDate
    );
}
