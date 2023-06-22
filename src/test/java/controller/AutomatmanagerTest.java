package controller;

import model.Getraenkeautomat;
import model.Muenze;
import model.MuenzenKasse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AutomatmanagerTest {

    @Test
    void kaufenVonMilchLiefertMilch() throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException, GetraenkAusverkauftException {
        Map<String, String> faecher = new HashMap<>();
        faecher.put("milch", "100");
        List<Muenze> muenzen = new ArrayList<>();
        muenzen.add(Muenze.Euro);
        MuenzenKasse muenzenKasse = new MuenzenKasse(100, muenzen);
        Getraenkeautomat getraenkeautomat = new Getraenkeautomat(muenzenKasse,"Guetersloh",faecher);
        Automatmanager automatmanager = new Automatmanager(getraenkeautomat);
        Assertions.assertEquals("milch",automatmanager.kaufen("milch",muenzen).getName());
    }

    @Test
    void shouldThrowGetraenkAusverkauftException() throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException, GetraenkAusverkauftException {
        Map<String, String> faecher = new HashMap<>();
        faecher.put("milch", "100");
        List<Muenze> muenzen = new ArrayList<>();
        muenzen.add(Muenze.Euro);
        MuenzenKasse muenzenKasse = new MuenzenKasse(100, muenzen);
        Getraenkeautomat getraenkeautomat = new Getraenkeautomat(muenzenKasse,"Guetersloh",faecher);
        Automatmanager automatmanager = new Automatmanager(getraenkeautomat);
        Assertions.assertThrows(GetraenkAusverkauftException.class, () -> {
            automatmanager.kaufen("o-saft",muenzen);
        });
    }

    @Test
    void shouldThrowMuenzenKasseIsEmptyException() throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException, GetraenkAusverkauftException {
        Map<String, String> faecher = new HashMap<>();
        faecher.put("milch", "100");
        List<Muenze> muenzen = new ArrayList<>();
        MuenzenKasse muenzenKasse = new MuenzenKasse(0, muenzen);
        Getraenkeautomat getraenkeautomat = new Getraenkeautomat(muenzenKasse,"Guetersloh",faecher);
        Automatmanager automatmanager = new Automatmanager(getraenkeautomat);
        Assertions.assertThrows(MuenzenKasseIsEmptyException.class, () -> {
            automatmanager.kaufen("milch",muenzen);
        });
    }

    @Test
    void kaufenVonMilchGibtWechselGeldInEuro() throws MuenzenKasseIsEmptyException, NoSufficentOrValidMuenzenException, GetraenkAusverkauftException {
        Map<String, String> faecher = new HashMap<>();
        faecher.put("milch", "100");
        List<Muenze> muenzen = new ArrayList<>();
        muenzen.add(Muenze.Euro);
        muenzen.add(Muenze.Euro);
        muenzen.add(Muenze.Euro);
        List<Muenze> muenzenkasse = new ArrayList<>();
        muenzenkasse.add(Muenze.Euro);
        muenzenkasse.add(Muenze.Euro);
        MuenzenKasse muenzenKasse = new MuenzenKasse(200, muenzenkasse);
        Getraenkeautomat getraenkeautomat = new Getraenkeautomat(muenzenKasse,"Guetersloh",faecher);
        Automatmanager automatmanager = new Automatmanager(getraenkeautomat);
        Assertions.assertEquals(1, automatmanager.kaufen("milch",muenzen).getMuenze().size());
    }


}