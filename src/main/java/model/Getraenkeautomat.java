package model;

import java.util.ArrayList;
import java.util.List;

public class Getraenkeautomat {
    private List<Fach> places;
    private List<Muenze> muenze;
    private String standort;

    public Getraenkeautomat(List<Fach> places, String standort, List<Muenze> muenze) {
        this.places = places;
        this.standort = standort;
        this.muenze = muenze;
    }

    public List<Fach> getPlaces() {
        return places;
    }

    public String getStandort() {
        return standort;
    }

    public void setPlaces(List<Fach> places) {
        this.places = places;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public List<Muenze> getMuenze() {
        return muenze;
    }

    public void setMuenze(List<Muenze> muenze) {
        this.muenze = muenze;
    }
}
