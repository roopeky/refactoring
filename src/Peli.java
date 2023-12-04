/**
 * Peli-luokka edustaa kivi-paperi-sakset -peliä.
 * Se sisältää pelilogiikan, pelaajien vuorovaikutuksen ja pääsilmukan.
 */
public class Peli {

    /**
     * Päämetodi kivi-paperi-sakset -pelin käynnistämiseen ja suorittamiseen.
     *
     * @param args Komentoriviparametrit (eivät ole käytössä tässä sovelluksessa).
     */
    public static void main(String args[]) {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        boolean peliPaattyi = false;
        int pelatutPelit = 0;
        int tasapelit = 0;

        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            String pelaaja1Valinta = pelaaja1.teeSatunnainenValinta();
            System.out.println("Pelaaja 1: " + pelaaja1Valinta + "\n\t Pelaaja 1:llä koossa " + pelaaja1.haeVoitot() + " voittoa.");

            String pelaaja2Valinta = pelaaja2.teeSatunnainenValinta();
            System.out.println("Pelaaja 2: " + pelaaja2Valinta + "\n\t Pelaaja 2:lla koossa " + pelaaja2.haeVoitot() + " voittoa.");

            tulostaTulos(pelaaja1Valinta, pelaaja2Valinta, pelaaja1, pelaaja2, tasapelit);

            if (pelaaja1.haeVoitot() >= 3 || pelaaja2.haeVoitot() >= 3) {
                peliPaattyi = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
            pelatutPelit++;
            System.out.println();
        } while (!peliPaattyi);
    }

    /**
     * Tulostaa pelituloksen pelaajien valintojen perusteella.
     *
     * @param valinta1 Pelaaja 1:n valinta.
     * @param valinta2 Pelaaja 2:n valinta.
     * @param pelaaja1 Pelaaja 1 -olion viite.
     * @param pelaaja2 Pelaaja 2 -olion viite.
     * @param tasapelit Tähän mennessä pelattujen tasapelien määrä.
     */
    private static void tulostaTulos(String valinta1, String valinta2, Pelaaja pelaaja1, Pelaaja pelaaja2, int tasapelit) {
        if (valinta1.equals(valinta2)) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        } else if (pelaaja1Voittaa(valinta1, valinta2)) {
            pelaaja1.lisaaVoitto();
            System.out.println("Pelaaja 1 voittaa");
        } else {
            pelaaja2.lisaaVoitto();
            System.out.println("Pelaaja 2 voittaa");
        }
    }
    /**
     * Tarkistaa, voittaako pelaaja 1 annetuilla valinnoilla.
     *
     * @param valinta1 Pelaaja 1:n valinta.
     * @param valinta2 Pelaaja 2:n valinta.
     * @return True, jos pelaaja 1 voittaa; muuten false.
     */
    private static boolean pelaaja1Voittaa(String valinta1, String valinta2) {
        return (valinta1.equals("kivi") && valinta2.equals("sakset")) ||
                (valinta1.equals("paperi") && valinta2.equals("kivi")) ||
                (valinta1.equals("sakset") && valinta2.equals("paperi"));
    }
}