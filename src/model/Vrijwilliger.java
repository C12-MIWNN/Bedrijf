package model;

/**
 * @author Vincent Velthuizen
 *
 * Beschrijft iemand die vrijwillig voor ons bedrijf werkt
 */
public class Vrijwilliger extends Persoon implements Oproepbaar {
    public static final int DEFAULT_UREN_GEWERKT = 0;
    public static final int DEFAULT_JAARINKOMEN = 0;
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public double berekenJaarinkomen() {
        return DEFAULT_JAARINKOMEN;
    }

    @Override
    public void huurIn(int aantalUren) {
        urenGewerkt += aantalUren;
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger", super.toString());
    }
}
