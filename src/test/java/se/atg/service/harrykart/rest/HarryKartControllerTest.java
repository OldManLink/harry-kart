package se.atg.service.harrykart.rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.atg.service.harrykart.HarryKartServiceImpl;
import se.atg.service.harrykart.models.RacePosition;
import se.atg.service.harrykart.models.RaceResult;
import se.atg.service.harrykart.models.xjc.HarryKartType;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static se.atg.service.harrykart.utils.TestFileReader.readInputFile;


public class HarryKartControllerTest {

    @Test
    public void testHandleXML() {
        final HarryKartController controller = new HarryKartController(new HarryKartServiceImpl());
        final HarryKartType input = readInputFile(0);
        final RaceResult result = controller.handleXML(input);
        final RaceResult expectedResult = new RaceResult(Stream.of(
                new RacePosition("TIMETOBELUCKY", 1),
                new RacePosition("HERCULES BOKO", 2),
                new RacePosition("CARGO DOOR", 3)
        ).collect(toList()));
        Assert.assertEquals(result, expectedResult);
    }
}