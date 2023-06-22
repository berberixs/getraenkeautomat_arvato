package model;

import java.util.List;

public class MuenzenKasse {
    private int stand;
    private List<Muenze> muenzen;

    public MuenzenKasse(int stand, List<Muenze> muenzen) {
        this.stand = stand;
        this.muenzen = muenzen;
    }

    public int getStand() {
        return stand;
    }

    public List<Muenze> getMuenzen() {
        return muenzen;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }

    public void setMuenzen(List<Muenze> muenzen) {
        this.muenzen = muenzen;
    }
}
