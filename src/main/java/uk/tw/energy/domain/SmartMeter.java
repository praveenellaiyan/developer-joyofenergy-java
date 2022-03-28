package uk.tw.energy.domain;

import java.beans.Transient;
import java.util.Objects;

public class SmartMeter {

    private String smartMeterId;

    public SmartMeter(String smartMeterId) {
        this.smartMeterId = Objects.requireNonNull(smartMeterId);
    }

    public SmartMeter() {
    }

    public String getSmartMeterId() {
        return smartMeterId;
    }

    @Transient
    public boolean isValid() {
        return !smartMeterId.isEmpty();
    }
}
