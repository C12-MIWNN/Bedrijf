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
            System.out.println("Het lukte niet om het bestand te vinden");
        }

        System.out.println(afdelingen);

    }

}
