package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fach {
    private List<Getraenk> getraenks = new ArrayList<>();

    public Fach(List<Getraenk> getraenks) {
        this.getraenks = getraenks;
    }

    public List<Getraenk> getGetraenks() {
        return getraenks;
    }

    public void setGetraenks(List<Getraenk> getraenks) {
        this.getraenks = getraenks;
    }

}
