package se.atg.service.harrykart.models;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.FLOOR;

public class Race {

    public static BigDecimal DEFAULT_LOOP_LENGTH = BigDecimal.valueOf(1000000L, 3);
    private BigDecimal loopLength;
    private List<Horse> horses;

    public Race(BigDecimal loopLength, List<Horse> horses) {
        this.loopLength = loopLength;
        this.horses = horses;
    }

    public RaceResult getResult() {
        List<RaceTime> raceTimes = horses.stream().map(this::getRaceTime).collect(Collectors.toList());
        return new RaceResult(getRanking(raceTimes));
    }

    private RaceTime getRaceTime(Horse horse) {
        BigDecimal time = horse.getSpeeds().stream()
                .reduce(ZERO, (sum, speed) -> sum.add(loopLength.divide(speed, FLOOR)));
        return new RaceTime(time, horse.getName());
    }

    private List<RacePosition> getRanking(List<RaceTime> raceTimes) {
        List<RaceTime> winnersSorted = raceTimes.stream().sorted(Comparator.comparing(RaceTime::getTime))
                .collect(Collectors.toList()).subList(0, Math.min(3, raceTimes.size()));
        List<RacePosition> ranking = winnersSorted.stream().map(rt -> new RacePosition(winnersSorted.indexOf(rt) + 1, rt.getHorse()))
                .collect(Collectors.toList());

        // Fix so that if any horses have the same race time, they also have the same position
        for (int i = 1 ; i < winnersSorted.size() ; i++) {
            RaceTime second = winnersSorted.get(i);
            RaceTime first = winnersSorted.get(i - 1);

            if (second.getTime().equals(first.getTime())) {
                ranking.get(i).setPosition(ranking.get(i - 1).getPosition());
            }
        }
        return ranking;
    }

    private static class RaceTime {

        private BigDecimal time;
        private String horse;

        RaceTime(BigDecimal time, String horse) {
            this.time = time;
            this.horse = horse;
        }

        BigDecimal getTime() {
            return time;
        }

        String getHorse() {
            return horse;
        }
    }
}
