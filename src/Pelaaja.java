/**
 * Luokka edustaa yhtä pelaajaa kivi-paperi-sakset -pelissä.
 */
public class Pelaaja {

    private int voitot;

    /**
     * Metodi suorittaa satunnaisen valinnan kiven, paperin ja saksien välillä.
     *
     * @return Pelaajan tekemä valinta (kivi, paperi tai sakset).
     */
    public String teeSatunnainenValinta() {
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                return "kivi";
            case 1:
                return "paperi";
            case 2:
                return "sakset";
            default:
                return ""; // Ei pitäisi koskaan päätyä tähän
        }
    }

    /**
     * Metodi lisää pelaajalle voiton.
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Metodi palauttaa pelaajan voittojen lukumäärän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int haeVoitot() {
        return voitot;
    }
}