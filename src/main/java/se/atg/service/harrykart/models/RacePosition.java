package se.atg.service.harrykart.models;

import java.util.Objects;

public class RacePosition implements java.io.Serializable {

    private final String horse;
    private final int position;

    public RacePosition(String horse, int position) {
        this.horse = horse;
        this.position = position;
    }

    public String getHorse() {
        return horse;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object obj){
        if (null == obj) return false;
        if (this.getClass() != obj.getClass()) return false;
        RacePosition other = (RacePosition) obj;
        if (this.getPosition() != other.getPosition()) return false;
        return this.getHorse().equals(other.getHorse());
    }

    @Override
    public int hashCode(){
        return Objects.hash(position, horse);
    }

    @Override
    public String toString() {
        return "RacePosition {" +
                "horse: \"" + horse + "\", " +
                "position: " + position + ", " +
                "}";
    }
}
