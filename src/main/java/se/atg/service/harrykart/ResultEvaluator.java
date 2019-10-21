package se.atg.service.harrykart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.atg.service.harrykart.models.RacePosition;
import se.atg.service.harrykart.models.RaceResult;
import se.atg.service.harrykart.models.RaceTime;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class ResultEvaluator {
    private final static Logger logger = LoggerFactory.getLogger(ResultEvaluator.class);

    private final List<RaceTime> raceTimes;

    ResultEvaluator(List<RaceTime> raceTimes) {
        this.raceTimes = raceTimes;
    }

    RaceResult getResult() {
        return new RaceResult(fixNeckAndNeckPositions(getRanking()));
    }

    private List<RacePosition> getRanking() {
        logger.info("Sorting race times {}", raceTimes);
        List<RaceTime> winnersSorted = raceTimes.stream().sorted(Comparator.comparing(RaceTime::getTime))
                .collect(toList()).subList(0, Math.min(3, raceTimes.size()));
        logger.info("Ranked winners {}", winnersSorted);
        return winnersSorted.stream().map(rt -> new RacePosition(rt.getHorse(), winnersSorted.indexOf(rt) + 1))
                .collect(toList());
    }

    private List<RacePosition> fixNeckAndNeckPositions(final List<RacePosition> ranking) {
        logger.info("Checking tie-breakers: {}", ranking);
        return IntStream.range(0, ranking.size()).mapToObj(i -> fixRanking(ranking, i)).collect(toList());
    }

    /**
     * Correct the RacePosition in the supplied ranking at the supplied index so that if any horses have the
     * same race time, they are awarded the same position.
     * @param ranking the calculated ranking before correction
     * @param index the index of the RacePosition to examine
     * @return a corrected copy of the existing RacePosition, or the existing one if it didn't need correction
     */
    private RacePosition fixRanking(final List<RacePosition> ranking, final int index) {
        if (index == 0) return ranking.get(0);
        final RaceTime second = raceTimes.get(index);
        final RaceTime first = raceTimes.get(index - 1);

        if (second.getTime().equals(first.getTime())) {
            final RacePosition toFix = ranking.get(index);
            final RacePosition tiedWith = ranking.get(index - 1);
            logger.info("Fixing tie-break position for {}, tied with {}", toFix, tiedWith);
            return new RacePosition(toFix.getHorse(), fixRanking(ranking, index - 1).getPosition());
        } else {
            return ranking.get(index);
        }
    }
}
