package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static se.atg.service.harrykart.models.Race.DEFAULT_LOOP_LENGTH;

public class HorseTest {

    @Test
    public void testGetRaceTime() {
        Horse horse = new Horse("Red Rum", new ArrayList<>(
                Stream.of(10, 11, 13, 16).map(BigDecimal::valueOf).collect(Collectors.toList())));
        Assert.assertEquals(horse.getRaceTime(DEFAULT_LOOP_LENGTH), BigDecimal.valueOf(330.332));
    }

    @Test
    public void testGetEmptyRaceTime() {
        Horse horse = new Horse("Shergar", Collections.emptyList());
        Assert.assertEquals(horse.getRaceTime(DEFAULT_LOOP_LENGTH), BigDecimal.ZERO);
    }
}