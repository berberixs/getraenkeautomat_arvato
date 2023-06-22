package model;

import java.util.List;

public class GetraenkUndWechselgeld {
    private final String name;
    private List<Muenze> muenze;

    public GetraenkUndWechselgeld(String name, List<Muenze> muenze) {
        this.name = name;
        this.muenze = muenze;
    }

    public String getName() {
        return name;
    }

    public List<Muenze> getMuenze() {
        return muenze;
    }
}
