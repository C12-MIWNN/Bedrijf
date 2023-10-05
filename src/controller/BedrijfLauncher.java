package controller;

import database.AfdelingDAO;
import database.DBaccess;
import database.WerknemerDAO;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        DBaccess dBaccess = new DBaccess("Bedrijf",
                "userBedrijf",
                "userBedrijfPW");

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);
        WerknemerDAO werknemerDAO = new WerknemerDAO((dBaccess));

        dBaccess.openConnection();

        Afdeling afdeling = afdelingDAO.geefAfdeling("Support");
        Werknemer lodewijk = new Werknemer("Lodewijk", "Zaandam", afdeling, 2500);

        werknemerDAO.slaWerknemerOp(lodewijk);

        dBaccess.closeConnection();
    }

}
