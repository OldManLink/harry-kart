package se.atg.service.harrykart;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.models.Horse;
import se.atg.service.harrykart.models.Race;
import se.atg.service.harrykart.models.RaceResult;
import se.atg.service.harrykart.models.xjc.HarryKartType;
import se.atg.service.harrykart.models.xjc.LaneType;
import se.atg.service.harrykart.models.xjc.LoopType;
import se.atg.service.harrykart.models.xjc.ParticipantType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ZERO;
import static se.atg.service.harrykart.models.Race.DEFAULT_LOOP_LENGTH;

@Service
public class HarryKartServiceImpl implements HarryKartService {

    @Override
    public RaceResult computeResult(HarryKartType harryKart) {
        Race race = new Race(DEFAULT_LOOP_LENGTH, getHorses(harryKart));

        return race.getResult();
    }

    private List<Horse> getHorses(HarryKartType harryKart) {
        List<ParticipantType> participants = harryKart.getStartList().getParticipant();
        return participants.stream().map(p -> getHorse(p, harryKart)).collect(Collectors.toList());
    }

    private Horse getHorse(ParticipantType p, HarryKartType harryKart) {
        List<BigDecimal> speeds = getPowerUps(p, harryKart)
                .map(pu ->  pu.add(new BigDecimal(p.getBaseSpeed()))).collect(Collectors.toList());
        return new Horse(p.getName(), speeds);
    }

    private Stream<BigDecimal> getPowerUps(ParticipantType p, HarryKartType harryKart) {
        return IntStream.range(0, harryKart.getNumberOfLoops().intValue())
                .mapToObj(i -> getPowerUp(i, p.getLane(), harryKart));
    }

    private BigDecimal getPowerUp(int loopNumber, BigInteger laneNumber, HarryKartType harryKart) {
        LoopType loop = harryKart.getPowerUps().getLoop().stream()
                .filter(l -> loopNumber == l.getNumber().intValue()).findAny().orElse(new LoopType());
        BigInteger powerUp = loop.getLane().stream().filter(l -> laneNumber.equals(l.getNumber()))
                .findAny().map(LaneType::getValue).orElse(ZERO);
        if (loopNumber == 0) {
            return new BigDecimal(powerUp);
        } else {
            return new BigDecimal(powerUp).add(getPowerUp(loopNumber - 1, laneNumber, harryKart));
        }
    }
}
