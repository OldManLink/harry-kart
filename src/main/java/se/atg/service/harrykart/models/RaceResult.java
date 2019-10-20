package se.atg.service.harrykart.models;

import java.util.List;

public class RaceResult implements java.io.Serializable {

    private List<RacePosition> ranking;

    public RaceResult(List<RacePosition> ranking) {
        this.ranking = ranking;
    }

    public RaceResult() {}

    public List<RacePosition> getRanking() {
        return ranking;
    }

    public void setRanking(List<RacePosition> ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "RaceResult {" +
                "ranking: " + ranking +
                "}";
    }
}
