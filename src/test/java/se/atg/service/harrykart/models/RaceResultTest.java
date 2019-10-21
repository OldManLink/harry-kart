package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class RaceResultTest {

    //noinspection Simplifiable
    private final RaceResult first = new RaceResult(Arrays.asList(new RacePosition("Red Rum", 1)));
    private final RaceResult second = new RaceResult(Arrays.asList(new RacePosition("Red Rum", 1)));
    private final RaceResult third = new RaceResult(Arrays.asList(new RacePosition("Shergar", 1)));
    private final RaceTime time = new RaceTime("Red Rum", BigDecimal.valueOf(334498L, 3));

    @Test
    public void testEquals() {
        //noinspection Simplifiable
        Assert.assertTrue(first.equals(second));
        Assert.assertFalse(first.equals(null));
        Assert.assertFalse(first.equals(time));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(first.hashCode(), second.hashCode());
        Assert.assertNotEquals(first.hashCode(), time.hashCode());
    }
}