package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Een persoon betrokken bij ons bedrijf
 */
public class Persoon {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final double DEFAULT_MAANDSALARIS = 0.0;

    private static final int MAANDEN_PER_JAAR = 12;
    private static final double GRENSWAARDE_BONUS = 4500.0;

    private static int aantalPersonen = 0;

    private final int personeelsnummer;
    private final String naam;
    private final String woonplaats;
    private double maandsalaris;

    public Persoon(String naam, String woonplaats, double maandsalaris) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandsalaris(maandsalaris);
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAANDSALARIS);
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarinkomen() {
        return MAANDEN_PER_JAAR * maandsalaris;
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
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

    public double getMaandsalaris() {
        return maandsalaris;
    }

    private void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            System.err.printf("Het maandsalaris mag niet negatief zijn! Het maandsalaris wordt op %.1f gezet.\n",
                    DEFAULT_MAANDSALARIS);
            this.maandsalaris = DEFAULT_MAANDSALARIS;

        } else {
            this.maandsalaris = maandsalaris;
        }
    }

}
