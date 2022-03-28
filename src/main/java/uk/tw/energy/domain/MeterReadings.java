package uk.tw.energy.domain;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;

public class MeterReadings {

    private List<ElectricityReading> electricityReadings;
    private SmartMeter smartMeter;

    public MeterReadings() {
    }

    public MeterReadings(SmartMeter smartMeter, List<ElectricityReading> electricityReadings) {
        this.smartMeter = Objects.requireNonNull(smartMeter);
        this.electricityReadings = electricityReadings;
    }

    public List<ElectricityReading> getElectricityReadings() {
        return electricityReadings;
    }

    public SmartMeter getSmartMeter() {
        return smartMeter;
    }

    @Transient
    public boolean isValid() {
        return smartMeter.isValid()
                && Objects.nonNull(electricityReadings) && !electricityReadings.isEmpty();
    }
}
