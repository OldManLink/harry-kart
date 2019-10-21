package se.atg.service.harrykart.models;

import java.math.BigDecimal;
import java.util.Objects;

public class RaceTime {

    private final String horse;
    private final BigDecimal time;

    public RaceTime(final String horse, final BigDecimal time) {
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
    public boolean equals(final Object obj) {
        if (null == obj) return false;
        if (this.getClass() != obj.getClass()) return false;
        RaceTime other = (RaceTime) obj;
        return Objects.equals(this.getHorse(), other.getHorse()) && Objects.equals(this.getTime(), other.getTime());
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
