package se.atg.service.harrykart.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.FLOOR;

class Horse {
    private final static Logger logger = LoggerFactory.getLogger(Horse.class);
    private final String name;
    private final BigDecimal baseSpeed;
    private final List<BigDecimal> powerUps;

    Horse(final String name, final BigDecimal baseSpeed, final List<BigDecimal> powerUps){
        this.name = name;
        this.baseSpeed = baseSpeed;
        this.powerUps = powerUps;
    }

    public String getName() {
        return name;
    }

    private BigDecimal getBaseSpeed() {
        return baseSpeed;
    }

    private List<BigDecimal> getPowerUps() {
        return powerUps;
    }

    private BigDecimal getPowerUp(int i) {
        return getPowerUps().get(i);
    }

    private int getPowerUpsCount() {
        return getPowerUps().size();
    }

    BigDecimal getRaceTime(final BigDecimal loopLength) {
        logger.info("Calculating race time for {}", this);
        Stream<BigDecimal> speeds = this.getCumulativePowerUps().map(pu -> pu.add(this.getBaseSpeed()));
        return speeds.reduce(ZERO, (sum, speed) -> sum.add(loopLength.divide(speed, FLOOR)));
    }

    private Stream<BigDecimal> getCumulativePowerUps() {
        return IntStream.range(0, getPowerUpsCount()).mapToObj(this::getCumulativePowerUp);
    }

    private BigDecimal getCumulativePowerUp(final int i) {
        return i == 0 ? getPowerUp(i) : getPowerUp(i).add(getCumulativePowerUp(i - 1));
    }

    @Override
    public String toString() {
        return "Horse {" +
                "name: \"" + name + "\", " +
                "baseSpeed: " + baseSpeed + ", " +
                "powerUps: " + powerUps +
                "}";
    }
}
