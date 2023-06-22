package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

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

    public GetraenkUndWechselgeld kaufen(String name, List<Muenze> einzahlung) throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException, GetraenkAusverkauftException {
        List<Muenze> muenzen;
        if (getraenkeautomat.contains(name)) {
            muenzen = giveChangeFor(einzahlung);
        } else {
            throw new GetraenkAusverkauftException();
        }
        return new GetraenkUndWechselgeld(name,muenzen);
    }

    private List<Muenze> giveChangeFor(List<Muenze> einzahlung) throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException {
        int kassenStand = getraenkeautomat.getMuenzenKasse().getStand();
        int betrag = muenzenSumme(einzahlung);
        if (getraenkeautomat.muezenKasseIsEmpty()) {
            throw new MuenzenKasseIsEmptyException();
        } else if (kassenStand == betrag){
            return getraenkeautomat.getMuenzenKasse().getMuenzen();
        } else {
            return prepareMuenzen(Math.abs(betrag -kassenStand));
        }
    }

    private int muenzenSumme(List<Muenze> einzahlung) {
        int sum = 0;
        for (Muenze muenze : einzahlung) {
            sum = sum + muenze.getValue();
        }
        return sum;
    }

    private List<Muenze> prepareMuenzen(int sum) throws NoSufficentOrValidMuenzenException {
        int initsum = sum;
        List<Muenze> exchangeResult = new ArrayList<>();

        for (Muenze muenze: getraenkeautomat.getMuenzenKasse().getMuenzen()) {
            int coinValue = muenze.getValue();

            if (sum >= coinValue) {
                int count = sum / coinValue;
                exchangeResult.add(muenze);
                sum -= count;
            }
        }
        if (muenzenSumme(exchangeResult) == initsum) {
            return exchangeResult;
        } else {
            System.out.println("Error: " + initsum );
            System.out.println("Error 1: " + muenzenSumme(exchangeResult) );
            throw new NoSufficentOrValidMuenzenException();
        }
    }

    public void einfuehlen() {
    }
}
