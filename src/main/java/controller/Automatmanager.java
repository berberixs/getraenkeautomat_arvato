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

    public GetraenkUndWechselgeld kaufen(String name, Muenze... einzahlung) throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException {
        if (getraenkeautomat.contains(name)) {
            giveChangeFor(einzahlung);
        }
        return new GetraenkUndWechselgeld("milk",null);
    }

    private List<Muenze> giveChangeFor(Muenze... einzahlung) throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException {
        int kassenStand = getraenkeautomat.getMuenzenKasse().getStand();
        int betrag = muenzenSumme(List.of(einzahlung));
        if (getraenkeautomat.muezenKasseIsEmpty()) {
            throw new MuenzenKasseIsEmptyException();
        } else if (kassenStand < betrag){
            throw new NoSufficentOrValidMuenzenException();
        } else if (kassenStand == betrag){
            return getraenkeautomat.getMuenzenKasse().getMuenzen();
        } else if (kassenStand > betrag){
            return prepareMuenzen(kassenStand - betrag);
        }
        return null;
    }

    private int muenzenSumme(List<Muenze> einzahlung) {
        int sum = 0;
        for (Muenze muenze : einzahlung) {
            sum = sum + muenze.getValue();
        }
        return sum;
    }

    private List<Muenze> prepareMuenzen(int sum) throws NoSufficentOrValidMuenzenException {
        List<Muenze> exchangeResult = new ArrayList<>();

        for (Muenze muenze: getraenkeautomat.getMuenzenKasse().getMuenzen()) {
            int coinValue = muenze.getValue();

            if (sum >= coinValue) {
                int count = sum / coinValue;
                exchangeResult.add(muenze);
                sum = count;
            }
        }
        if (muenzenSumme(exchangeResult) == sum) {
            return exchangeResult;
        } else {
            throw new NoSufficentOrValidMuenzenException();
        }
    }

    public void einfuehlen() {
    }
}
