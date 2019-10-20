package se.atg.service.harrykart.models;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.FLOOR;

public class Horse {
    private String name;
    private List<BigDecimal> speeds;

    public Horse(String name, List<BigDecimal> speeds){
        this.name = name;
        this.speeds = speeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<BigDecimal> getSpeeds() {
        return speeds;
    }

    BigDecimal getRaceTime(BigDecimal loopLength) {
        return this.getSpeeds().stream().reduce(ZERO, (sum, speed) -> sum.add(loopLength.divide(speed, FLOOR)));
    }
}
