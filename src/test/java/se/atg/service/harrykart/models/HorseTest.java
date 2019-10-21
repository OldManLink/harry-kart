package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.toList;
import static se.atg.service.harrykart.models.Race.DEFAULT_LOOP_LENGTH;

public class HorseTest {

    @Test
    public void testGetRaceTime() {
        final Horse horse = new Horse("Red Rum", TEN, new ArrayList<>(
                IntStream.rangeClosed(0, 3).mapToObj(BigDecimal::valueOf).collect(toList())));
        Assert.assertEquals(horse.getRaceTime(DEFAULT_LOOP_LENGTH), BigDecimal.valueOf(330.332));
    }

    @Test
    public void testGetSimpleRaceTime() {
        final Horse horse = new Horse("Shergar", TEN, Collections.singletonList(ZERO));
        Assert.assertEquals(horse.getRaceTime(TEN), BigDecimal.ONE);
    }
}
