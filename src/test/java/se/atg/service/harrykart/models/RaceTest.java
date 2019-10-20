package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceTest {

    @Test
    public void testGetResult() {

        Race race = new Race(Race.DEFAULT_LOOP_LENGTH, Stream.of(
                new Horse("Red Rum", Stream.of(10, 11, 13, 15).map(BigDecimal::valueOf).collect(Collectors.toList())),
                new Horse("Shergar", Stream.of(10, 12, 12, 15).map(BigDecimal::valueOf).collect(Collectors.toList())),
                new Horse("Nijinski", Stream.of(10, 13, 11, 14).map(BigDecimal::valueOf).collect(Collectors.toList()))
        ).collect(Collectors.toList()));

        RaceResult expectedResult = new RaceResult( Stream.of(
                new RacePosition(1, "Shergar"),
                new RacePosition(2, "Red Rum"),
                new RacePosition(3, "Nijinski")
        ).collect(Collectors.toList()));

        Assert.assertEquals(race.getResult().toString(), expectedResult.toString());
    }

    @Test
    public void testEveryonesAWinner() {

        Race race = new Race(Race.DEFAULT_LOOP_LENGTH, Stream.of(
                new Horse("Red Rum", Stream.of(10, 11, 13, 15).map(BigDecimal::valueOf).collect(Collectors.toList())),
                new Horse("Shergar", Stream.of(10, 11, 13, 15).map(BigDecimal::valueOf).collect(Collectors.toList())),
                new Horse("Nijinski", Stream.of(10, 11, 13, 15).map(BigDecimal::valueOf).collect(Collectors.toList()))
        ).collect(Collectors.toList()));

        RaceResult expectedResult = new RaceResult( Stream.of(
                new RacePosition(1, "Red Rum"),
                new RacePosition(1, "Shergar"),
                new RacePosition(1, "Nijinski")
        ).collect(Collectors.toList()));

        Assert.assertEquals(race.getResult().toString(), expectedResult.toString());
    }
}