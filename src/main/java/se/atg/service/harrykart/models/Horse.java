package se.atg.service.harrykart.models;

import java.math.BigDecimal;
import java.util.List;

public class Horse {
    private String name;
    private List<BigDecimal> speeds;

    public Horse(String name, List<BigDecimal> speeds){
        this.name = name;
        this.speeds = speeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<BigDecimal> getSpeeds() {
        return speeds;
    }

}
