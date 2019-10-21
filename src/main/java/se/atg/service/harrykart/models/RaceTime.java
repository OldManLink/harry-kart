package se.atg.service.harrykart.models;

import java.math.BigDecimal;
import java.util.Objects;

public class RaceTime {

    private final String horse;
    private final BigDecimal time;

    public RaceTime(String horse, BigDecimal time) {
        this.horse = horse;
        this.time = time;
    }

    public String getHorse() {
        return horse;
    }

    public BigDecimal getTime() {
        return time;
    }

    @Override
    public boolean equals(Object obj){
        if (null == obj) return false;
        if (this.getClass() != obj.getClass()) return false;
        RaceTime other = (RaceTime) obj;
        if (!Objects.equals(this.getHorse(), other.getHorse())) return false;
        return Objects.equals(this.getTime(), other.getTime());
    }

    @Override
    public int hashCode(){
        return Objects.hash(horse, time);
    }

    @Override
    public String toString() {
        return "RaceTime {" +
                "horse: \"" + horse + "\", " +
                "time: " + time + ", " +
                "}";
    }
}
