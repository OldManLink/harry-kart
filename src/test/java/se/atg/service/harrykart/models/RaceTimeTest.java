package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class RaceTimeTest {

    private final RaceTime first = new RaceTime("Red Rum", BigDecimal.valueOf(334498L, 3));
    private final RaceTime second = new RaceTime("Red Rum", BigDecimal.valueOf(334498L, 3));
    private final RaceTime third = new RaceTime("Red Rum", BigDecimal.valueOf(345678L, 3));
    private final RacePosition position = new RacePosition("Red Rum", 1);

    @Test
    public void testEquals() {
        //noinspection Simplifiable
        Assert.assertTrue(first.equals(second));
        Assert.assertFalse(first.equals(third));
        Assert.assertFalse(first.equals(null));
        Assert.assertFalse(first.equals(position));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(first.hashCode(), second.hashCode());
    }
}