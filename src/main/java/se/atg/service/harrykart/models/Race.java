package se.atg.service.harrykart.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Race {
    private final static Logger logger = LoggerFactory.getLogger(Race.class);

    static final BigDecimal DEFAULT_LOOP_LENGTH = BigDecimal.valueOf(1000000L, 3);
    private final BigDecimal loopLength;
    private final List<Horse> horses;

    Race(final BigDecimal loopLength, final List<Horse> horses) {
        this.loopLength = loopLength;
        this.horses = horses;
    }

    public List<RaceTime> getRaceTimes() {
        logger.info("Calculating race times");
        return horses.stream().map(h -> new RaceTime(h.getName(), h.getRaceTime(loopLength))).collect(toList());
    }
}
