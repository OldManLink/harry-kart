package se.atg.service.harrykart.models;

import java.util.List;
import java.util.Objects;

public class RaceResult implements java.io.Serializable {

    private final List<RacePosition> ranking;

    public RaceResult(List<RacePosition> ranking) {
        this.ranking = ranking;
    }

    public List<RacePosition> getRanking() {
        return ranking;
    }

    @Override
    public boolean equals(Object obj){
        if (null == obj) return false;
        if (this.getClass() != obj.getClass()) return false;
        RaceResult other = (RaceResult) obj;
        return Objects.deepEquals(this.getRanking().toArray(), other.getRanking().toArray());
    }

    @Override
    public int hashCode(){
        return Objects.hash(ranking);
    }

    @Override
    public String toString() {
        return "RaceResult {" +
                "ranking: " + ranking +
                "}";
    }
}
