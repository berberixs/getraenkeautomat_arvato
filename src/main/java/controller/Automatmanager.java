package controller;

import model.Getraenk;
import model.GetraenkUndWechselgeld;
import model.Getraenkeautomat;
import model.Muenze;

public class Automatmanager {
    private Getraenkeautomat getraenkeautomat;

    public Automatmanager(Getraenkeautomat getraenkeautomat) {
        this.getraenkeautomat = getraenkeautomat;
    }

    public Getraenkeautomat getGetraenkeautomat() {
        return getraenkeautomat;
    }

    public void setGetraenkeautomat(Getraenkeautomat getraenkeautomat) {
        this.getraenkeautomat = getraenkeautomat;
    }

    public GetraenkUndWechselgeld kaufen(Getraenk name, Muenze... einzahlung){
        return new GetraenkUndWechselgeld();
    }
}
