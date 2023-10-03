package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Eigenschappen van die personen die in vaste dienst zijn bij mijn bedrijf
 */
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500;
    private static final double DEFAULT_MAAND_SALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;

    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        setMaandsalaris(maandSalaris);
    }

    public Werknemer(String naam) {
        super(naam);
        setMaandsalaris(DEFAULT_MAAND_SALARIS);
    }

    public Werknemer() {
        super();
        setMaandsalaris(DEFAULT_MAAND_SALARIS);
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarinkomen() {
        double jaarinkomen = MAANDEN_PER_JAAR * maandSalaris;

        if (heeftRechtOpBonus()) {
            jaarinkomen += maandSalaris;
        }

        return jaarinkomen;
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op bonus",
                super.toString(), heeftRechtOpBonus() ? "met" : "zonder");
    }

    private void setMaandsalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            throw new IllegalArgumentException("Het maandsalaris mag niet negatief zijn.");
        }

        this.maandSalaris = maandSalaris;
    }
}
