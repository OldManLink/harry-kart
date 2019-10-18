package se.atg.service.harrykart;

import se.atg.service.harrykart.models.xjc.HarryKartType;
import se.atg.service.harrykart.models.RaceResult;

public interface HarryKartService {

    public abstract RaceResult computeResult(HarryKartType harryKart);
}
