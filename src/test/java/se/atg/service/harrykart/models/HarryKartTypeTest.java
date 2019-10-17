package se.atg.service.harrykart.models;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import java.io.File;
import java.math.BigInteger;
import java.util.Objects;

public class HarryKartTypeTest {

    @Test
    public void testDeserialize() {
        HarryKartType harryKart = null;
        File xml = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("input_0.xml")).getFile());

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            harryKart = ((JAXBElement<HarryKartType>)  jaxbContext.createUnmarshaller().unmarshal(xml)).getValue();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        assert harryKart != null;
        Assert.assertEquals(harryKart.numberOfLoops, BigInteger.valueOf(3));
        Assert.assertEquals(harryKart.startList.participant.size(), 4);
        Assert.assertEquals(harryKart.startList.participant.get(2).name, "HERCULES BOKO");
        Assert.assertEquals(harryKart.powerUps.loop.get(1).lane.get(3).value, BigInteger.valueOf(-2));
    }
}