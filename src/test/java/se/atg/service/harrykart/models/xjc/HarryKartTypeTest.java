package se.atg.service.harrykart.models.xjc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static se.atg.service.harrykart.utils.TestFileReader.readInputFile;

public class HarryKartTypeTest {

    @Test
    public void testDeserialize() {
        HarryKartType harryKart = readInputFile(0);

        Assert.assertEquals(harryKart.numberOfLoops, BigInteger.valueOf(3));
        Assert.assertEquals(harryKart.startList.participant.size(), 4);
        Assert.assertEquals(harryKart.startList.participant.get(2).name, "HERCULES BOKO");
        Assert.assertEquals(harryKart.powerUps.loop.get(1).lane.get(3).value, BigInteger.valueOf(-2));
    }
}