package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class RacePositionTest {

    private final RacePosition first = new RacePosition("Red Rum", 1);
    private final RacePosition second = new RacePosition("Red Rum", 1);
    private final RacePosition third = new RacePosition("Red Rum", 3);
    private final RaceTime time = new RaceTime("Red Rum", BigDecimal.valueOf(334498L, 3));

    @Test
    public void testEquals() {
        //noinspection Simplifiable
        Assert.assertTrue(first.equals(second));
        Assert.assertFalse(first.equals(third));
        Assert.assertFalse(first.equals(null));
        Assert.assertFalse(first.equals(time));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(first.hashCode(), second.hashCode());
    }
}