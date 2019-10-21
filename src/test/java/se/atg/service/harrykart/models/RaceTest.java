package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static java.math.BigDecimal.TEN;
import static java.util.stream.Collectors.toList;
import static se.atg.service.harrykart.models.Race.DEFAULT_LOOP_LENGTH;

public class RaceTest {

    @Test
    public void testGetRaceTimes() {

        final Race race = new Race(DEFAULT_LOOP_LENGTH, Stream.of(
                new Horse("Red Rum", TEN, Stream.of(0, 1, 2, 2).map(BigDecimal::valueOf).collect(toList())),
                new Horse("Shergar", TEN, Stream.of(0, 2, 0, 3).map(BigDecimal::valueOf).collect(toList())),
                new Horse("Nijinski", TEN, Stream.of(0, 3, -2, 3).map(BigDecimal::valueOf).collect(toList()))
        ).collect(toList()));

        final List<RaceTime> expectedTimes = Stream.of(
                new RaceTime("Red Rum", BigDecimal.valueOf(334498L, 3)),
                new RaceTime("Shergar", BigDecimal.valueOf(333332L, 3)),
                new RaceTime("Nijinski", BigDecimal.valueOf(339260L, 3))
        ).collect(toList());

        Assert.assertEquals(race.getRaceTimes(), expectedTimes);
    }

    @Test
    public void testNeckAndNeckTimes() {

        final Race race = new Race(DEFAULT_LOOP_LENGTH, Stream.of(
                new Horse("Red Rum", TEN, Stream.of(0, 1, 2, 3).map(BigDecimal::valueOf).collect(toList())),
                new Horse("Shergar", TEN, Stream.of(0, 1, 2, 3).map(BigDecimal::valueOf).collect(toList())),
                new Horse("Nijinski", TEN, Stream.of(0, 1, 2, 3).map(BigDecimal::valueOf).collect(toList()))
        ).collect(toList()));

        final List<RaceTime> expectedTimes = Stream.of(
                new RaceTime("Red Rum", BigDecimal.valueOf(330332L, 3)),
                new RaceTime("Shergar", BigDecimal.valueOf(330332L, 3)),
                new RaceTime("Nijinski", BigDecimal.valueOf(330332L, 3))
        ).collect(toList());

        Assert.assertEquals(race.getRaceTimes(), expectedTimes);
    }
}
