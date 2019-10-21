package se.atg.service.harrykart;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.atg.service.harrykart.models.RacePosition;
import se.atg.service.harrykart.models.RaceResult;
import se.atg.service.harrykart.models.RaceTime;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ResultEvaluatorTest {

    @Test
    public void testGetResult() {

        final ResultEvaluator evaluator = new ResultEvaluator(Stream.of(
                new RaceTime("Red Rum", BigDecimal.valueOf(334498L, 3)),
                new RaceTime("Shergar", BigDecimal.valueOf(333332L, 3)),
                new RaceTime("Nijinski", BigDecimal.valueOf(339260L, 3))
        ).collect(toList()));

        final RaceResult expectedResult = new RaceResult(Stream.of(
                new RacePosition("Shergar", 1),
                new RacePosition("Red Rum", 2),
                new RacePosition("Nijinski", 3)
        ).collect(toList()));

        Assert.assertEquals(evaluator.getResult(), expectedResult);
    }

    @Test
    public void testEveryOnesAWinner() {

        final ResultEvaluator evaluator = new ResultEvaluator(Stream.of(
                new RaceTime("Red Rum", BigDecimal.valueOf(330332L, 3)),
                new RaceTime("Shergar", BigDecimal.valueOf(330332L, 3)),
                new RaceTime("Nijinski", BigDecimal.valueOf(330332L, 3))
        ).collect(toList()));

        final RaceResult expectedResult = new RaceResult(Stream.of(
                new RacePosition("Red Rum", 1),
                new RacePosition("Shergar", 1),
                new RacePosition("Nijinski", 1)
        ).collect(toList()));

        Assert.assertEquals(evaluator.getResult(), expectedResult);
    }
}