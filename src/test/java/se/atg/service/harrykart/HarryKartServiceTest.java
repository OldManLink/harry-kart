package se.atg.service.harrykart;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.atg.service.harrykart.models.RaceResult;

import static se.atg.service.harrykart.utils.TestFileReader.readInputFile;

public class HarryKartServiceTest {

    @Test
    public void testComputeResult_0() {
        HarryKartService service = new HarryKartServiceImpl();

        RaceResult result_0 = service.computeResult(readInputFile(0));

        Assert.assertEquals(result_0.getRanking().get(0).getPosition(), 1);
        Assert.assertEquals(result_0.getRanking().get(1).getPosition(), 2);
        Assert.assertEquals(result_0.getRanking().get(2).getPosition(), 3);

        Assert.assertEquals(result_0.getRanking().get(0).getHorse(), "TIMETOBELUCKY");
        Assert.assertEquals(result_0.getRanking().get(0).getHorse(), "HERCULES BOKO");
        Assert.assertEquals(result_0.getRanking().get(0).getHorse(), "CARGO DOOR");
    }

    @Test
    public void testComputeResult_1() {
        HarryKartService service = new HarryKartServiceImpl();

        RaceResult result_0 = service.computeResult(readInputFile(1));

        Assert.assertEquals(result_0.getRanking().get(0).getPosition(), 1);
        Assert.assertEquals(result_0.getRanking().get(1).getPosition(), 2);
        Assert.assertEquals(result_0.getRanking().get(2).getPosition(), 3);

        Assert.assertEquals(result_0.getRanking().get(0).getHorse(), "WAIKIKI SILVIO");
        Assert.assertEquals(result_0.getRanking().get(0).getHorse(), "TIMETOBELUCKY");
        Assert.assertEquals(result_0.getRanking().get(0).getHorse(), "HERCULES BOKO");
    }

}