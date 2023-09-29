package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {

        Afdeling[] afdelingen = new Afdeling[4];

        afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
        afdelingen[1] = new Afdeling("Support", "Amsterdam");
        afdelingen[2] = new Afdeling("Management", "Almere");
        afdelingen[3] = new Afdeling("Documentatie", "Gouda");

        Persoon baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000);
        Persoon medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000);
        Persoon assistent = new Persoon("Klaas");

        System.out.printf("Het aantal personen in het bedrijf is %d\n", Persoon.getAantalPersonen());
        System.out.printf("%s werkt in %s en woont in %s\n",
                baas.getNaam(), baas.getAfdeling().getAfdelingsPlaats(), baas.getWoonplaats());
        System.out.printf("%s werkt op de afdeling %s en verdient %.2f\n",
                medewerker.getNaam(), medewerker.getAfdeling().getAfdelingsNaam(), medewerker.berekenJaarinkomen());
        System.out.printf("%s werkt in %s en woont in %s\n",
                assistent.getNaam(), assistent.getAfdeling().getAfdelingsPlaats(), assistent.getWoonplaats());

        System.out.println(baas);
        System.out.println(medewerker);
        System.out.println(assistent);
    }
}
