package se.atg.service.harrykart.models;

public class RacePosition implements java.io.Serializable {

    private int position;
    private String horse;

    public RacePosition(int position, String horse) {
        this.position = position;
        this.horse = horse;
    }

    public RacePosition() {}

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }
}
