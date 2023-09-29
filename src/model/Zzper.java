package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijft een zelfstandige die door ons bedrijf ingehuurd wordt.
 */
public class Zzper extends Persoon {
    private static final int DEFAULT_UREN_GEWERKT = 0;

    private final double uurTarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurTarief) {
        super(naam, woonplaats, afdeling);
        this.uurTarief = uurTarief;
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public double berekenJaarinkomen() {
        return uurTarief * urenGewerkt;
    }

    @Override
    public String toString() {
        return String.format("%s en is een zzp-er met een uurtarief van %.2f", super.toString(), this.uurTarief);
    }
}
