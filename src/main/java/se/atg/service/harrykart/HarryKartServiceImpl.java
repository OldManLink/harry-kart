package se.atg.service.harrykart;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.models.xjc.HarryKartType;
import se.atg.service.harrykart.models.RacePosition;
import se.atg.service.harrykart.models.RaceResult;

import java.util.Arrays;
import java.util.List;

@Service
public class HarryKartServiceImpl implements HarryKartService {

    @Override
    public RaceResult computeResult(HarryKartType harryKart) {
        List<RacePosition> ranking = Arrays.asList(new RacePosition(1, "Red Rum"), new RacePosition(2, "Nijinsky"), new RacePosition(3, "Shergar"));
        return new RaceResult(ranking);
    }
}
