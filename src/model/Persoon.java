package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Een persoon betrokken bij ons bedrijf
 */
public abstract class Persoon implements Comparable<Persoon> {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";

    private static int aantalPersonen = 0;

    private final int personeelsnummer;
    private final String naam;
    private final String woonplaats;
    private final Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public abstract double berekenJaarinkomen();

    @Override
    public int compareTo(Persoon anderePersoon) {
        return this.naam.compareTo(anderePersoon.naam);
    }

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", this.naam, this.woonplaats, this.afdeling);
    }

    public static int getAantalPersonen() {
        return aantalPersonen;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }
}
