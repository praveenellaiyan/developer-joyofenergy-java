package uk.tw.energy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import uk.tw.energy.domain.ElectricityReading;
import uk.tw.energy.domain.PlanPrice;
import uk.tw.energy.domain.PowerSupplier;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CostCalculationServiceTest {

    private CostCalculationService costCalculationService;

    @BeforeEach
    public void setUp() {
        costCalculationService = new CostCalculationService();
    }

    @Test
    public void givenPowerSupplierAndReadingsThenReturnCostCalculated() {
        //Arrange
        List<ElectricityReading> readings = Arrays.asList(
                new ElectricityReading(LocalDateTime.now().minusDays(2).toInstant(ZoneOffset.UTC), BigDecimal.valueOf(80)),
                new ElectricityReading(Instant.now(), BigDecimal.valueOf(50)));
        PowerSupplier supplier = new PowerSupplier("price-plan-0", "Eco energy",
                new PlanPrice(BigDecimal.TEN, Collections.emptyList()));

        //Act
        BigDecimal resultantCost = costCalculationService.calculateCost(readings, supplier);

        //Assert
        assertThat(resultantCost).isPositive();
    }
}
