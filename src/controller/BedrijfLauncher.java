package controller;

import database.AfdelingDAO;
import database.DBaccess;
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

        DBaccess dBaccess = new DBaccess("Bedrijf",
                "userBedrijf",
                "userBedrijfPW");

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);

        dBaccess.openConnection();
//        afdelingDAO.slaAfdelingOp(new Afdeling("HR", "Hilversum"));

        System.out.println(afdelingDAO.geefAfdelingenMetPlaats("Hilversum"));
    }

}
