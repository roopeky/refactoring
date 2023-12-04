import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PeliTest {

    @Test
    void testPeliLogiikka() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();

        // Testaa pelin logiikkaa (voittojen laskenta, pelin päättyminen jne.....)
        for (int i = 0; i < 5; i++) {
            String pelaaja1Valinta = pelaaja1.teeSatunnainenValinta();
            String pelaaja2Valinta = pelaaja2.teeSatunnainenValinta();

            if (pelaaja1Voittaa(pelaaja1Valinta, pelaaja2Valinta)) {
                pelaaja1.lisaaVoitto();
            } else if (pelaaja1Voittaa(pelaaja2Valinta, pelaaja1Valinta)) {
                pelaaja2.lisaaVoitto();
            }

            assertTrue(pelaaja1.haeVoitot() <= 3);
            assertTrue(pelaaja2.haeVoitot() <= 3);
        }
    }

    private boolean pelaaja1Voittaa(String valinta1, String valinta2) {
        return (valinta1.equals("kivi") && valinta2.equals("sakset")) ||
                (valinta1.equals("paperi") && valinta2.equals("kivi")) ||
                (valinta1.equals("sakset") && valinta2.equals("paperi"));
    }
}
