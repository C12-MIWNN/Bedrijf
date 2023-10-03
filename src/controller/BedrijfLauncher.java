package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Dagdagelijkse bezigheden in mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        String naam = keyboard.next();
        System.out.print("Geef de woonplaats: ");
        String woonplaats = keyboard.next();
        System.out.print("Geef de naam van de afdeling: ");
        String afdelingsNaam = keyboard.next();
        System.out.print("Geef de plaats van de afdeling: ");
        String afdelingsPlaats = keyboard.next();

        Afdeling afdeling = new Afdeling(afdelingsNaam, afdelingsPlaats);
        Werknemer werknemer = null;

        while (werknemer == null) {
            System.out.print("Geef het maandsalaris: ");
            double maandsalaris = keyboard.nextDouble();

            try {
                werknemer = new Werknemer(naam, woonplaats, afdeling, maandsalaris);
                System.out.println(werknemer);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
            }
        }

    }

}
