package controller;

import model.Persoon;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.getAantalPersonen());
        Persoon baas = new Persoon("Mark", "Den Haag", 10000);
        System.out.println(Persoon.getAantalPersonen());
        System.out.println(baas.getPersoneelsnummer());
        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);
        System.out.println(Persoon.getAantalPersonen());
        System.out.println(medewerker.getPersoneelsnummer());

        Persoon assistent = new Persoon ("Klaas");
        Persoon manager = new Persoon();
        System.out.println(Persoon.getAantalPersonen());

        vertelIetsOverPersoon(baas);
        vertelIetsOverPersoon(medewerker);
        vertelIetsOverPersoon(assistent);
        vertelIetsOverPersoon(manager);
    }

    private static void vertelIetsOverPersoon(Persoon persoon) {
        System.out.printf("%s verdient %.2f en heeft %s recht op een bonus\n",
                persoon.getNaam(),
                persoon.getMaandsalaris(),
                persoon.heeftRechtOpBonus() ? "wel" : "geen");
    }
}
