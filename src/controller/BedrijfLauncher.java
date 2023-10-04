package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {

        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        File afdelingenBestand = new File("resources/Afdelingen.txt");

        try (Scanner afdelingenScanner = new Scanner(afdelingenBestand)) {
            while (afdelingenScanner.hasNextLine()) {
                String afdelingsNaam = afdelingenScanner.nextLine();
                String afdelingsPlaats = afdelingenScanner.nextLine();
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het lukte niet om het afdelingen bestand te vinden");
        }

        ArrayList<Persoon> personen = new ArrayList<>();
        File personenCSV = new File("resources/Personen.csv");

        try (Scanner personenScanner = new Scanner(personenCSV)) {
            while (personenScanner.hasNextLine()) {
                String[] persoonsinfo = personenScanner.nextLine().split(",");

                String type = persoonsinfo[0];
                String naam = persoonsinfo[1];
                String woonplaats = persoonsinfo[2];

                int afdelingsIndex = Integer.parseInt(persoonsinfo[3]);
                Afdeling afdeling = afdelingen.get(afdelingsIndex);

                double ietsMetGeld = Double.parseDouble(persoonsinfo[4]);

                switch (type) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdeling, ietsMetGeld));
                        break;
                    case "Zzper":
                        personen.add(new Zzper(naam, woonplaats, afdeling, ietsMetGeld));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdeling));
                        break;
                    default:
                        System.out.printf("%s is geen geldig persoonstype, deze regel slaan we over", type);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het lukte niet om het personen bestand te vinden");
        }

        Collections.sort(personen);
        System.out.println(personen);
    }

}
