package se.atg.service.harrykart.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.atg.service.harrykart.models.xjc.LaneType;
import se.atg.service.harrykart.models.xjc.LoopType;
import se.atg.service.harrykart.models.xjc.ParticipantType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

import static java.math.BigInteger.ZERO;
import static java.util.stream.Collectors.toList;
import static se.atg.service.harrykart.models.Race.DEFAULT_LOOP_LENGTH;

public class RaceFactory {
    private final static Logger logger = LoggerFactory.getLogger(RaceFactory.class);

    private final int numberOfLoops;
    private final List<ParticipantType> participants;
    private final List<LoopType> loops;

    public RaceFactory(final int numberOfLoops, final List<ParticipantType> participants, final List<LoopType> loops) {
        this.numberOfLoops = numberOfLoops;
        this.participants = participants;
        this.loops = loops;
    }

    public Race createRace() {
        logger.info("Finding Horses in {}", participants);
        final List<Horse> horses = participants.stream().map(this::getHorse).collect(toList());
        return new Race(DEFAULT_LOOP_LENGTH, horses);
    }


    private Horse getHorse(final ParticipantType participant) {
        logger.info("Found {} in lane {}", participant.getName(), participant.getLane());
        List<BigDecimal> powerUps = IntStream.range(0, numberOfLoops).mapToObj(BigInteger::valueOf)
                .map(loopNumber -> getPowerUp(loopNumber, participant.getLane())).collect(toList());
        return new Horse(participant.getName(), new BigDecimal(participant.getBaseSpeed()), powerUps);
    }

    /**
     * Return the PowerUp value for the specified loop number and lane number
     *
     * @param loopNumber The number of the Loop for which the PowerUp should be fetched
     * @param laneNumber The number of the Lane for which the PowerUp should be fetched
     * @return The PowerUp value as a BigDecimal
     */
    private BigDecimal getPowerUp(final BigInteger loopNumber, final BigInteger laneNumber) {
        logger.info("Finding Power-up for loop {}, lane {}", loopNumber, laneNumber);
        BigInteger powerUp = loops.stream().filter(loop -> loopNumber.equals(loop.getNumber())).findAny()
                .flatMap(loop -> loop.getLane().stream().filter(lane -> laneNumber.equals(lane.getNumber())).findAny())
                .map(LaneType::getValue).orElse(ZERO);
        return new BigDecimal(powerUp);
    }
}
