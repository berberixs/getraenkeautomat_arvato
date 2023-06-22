package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Getraenkeautomat {
    private MuenzenKasse muenzenKasse;
    private String standort;
    private Map<String, String> faecher = new ConcurrentHashMap<String, String>();

    public Getraenkeautomat(MuenzenKasse muenzenKasse, String standort, Map<String, String> faecher) {
        this.muenzenKasse = muenzenKasse;
        this.standort = standort;
        this.faecher = faecher;
    }

    public MuenzenKasse getMuenzenKasse() {
        return muenzenKasse;
    }

    public void setMuenzenKasse(MuenzenKasse muenzenKasse) {
        this.muenzenKasse = muenzenKasse;
    }

    public void setFaecher(Map<String, String> faecher) {
        this.faecher = faecher;
    }

    public Map<String, String> getFaecher() {
        return faecher;
    }

    public Map<String, String> getGetraenks() {
        return faecher;
    }

    public void setGetraenks(Map<String, String> getraenks) {
        this.faecher = getraenks;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public boolean contains(String getraenkewunsch) {
        if (faecher.containsKey(getraenkewunsch)) {
            return true;
        }
        return false;
    }

    public boolean muezenKasseIsEmpty() {
        if (muenzenKasse.getStand() == 0) {
            return false;
        }
        return true;
    }
}
