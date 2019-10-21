package se.atg.service.harrykart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.atg.service.harrykart.models.Race;
import se.atg.service.harrykart.models.RaceFactory;
import se.atg.service.harrykart.models.RaceResult;
import se.atg.service.harrykart.models.xjc.HarryKartType;
import se.atg.service.harrykart.models.xjc.LoopType;
import se.atg.service.harrykart.models.xjc.ParticipantType;

import java.util.List;

@Service
class HarryKartServiceImpl implements HarryKartService {
    private final static Logger logger = LoggerFactory.getLogger(HarryKartServiceImpl.class);

    @Override
    public RaceResult computeResult(final HarryKartType harryKart) {
        logger.info("Extracting data from HarryKartType instance");
        final int loopCount = harryKart.getNumberOfLoops().intValue();
        final List<ParticipantType> participants = harryKart.getStartList().getParticipant();
        final List<LoopType> loops = harryKart.getPowerUps().getLoop();

        logger.info("Creating Race instance");
        final Race race = new RaceFactory(loopCount, participants, loops).createRace();
        final ResultEvaluator evaluator = new ResultEvaluator(race.getRaceTimes());

        logger.info("Evaluating RaceResult");
        return evaluator.getResult();
    }
}
