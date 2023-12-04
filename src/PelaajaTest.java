import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {

    @Test
    void testTeeSatunnainenValinta() {
        Pelaaja pelaaja = new Pelaaja();

        // Testaa, että pelaajan valinta on oikea (kivi, paperi tai sakset)
        String valinta = pelaaja.teeSatunnainenValinta();
        assertNotNull(valinta);
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }

    @Test
    void testLisaaVoitto() {
        Pelaaja pelaaja = new Pelaaja();

        // Testaa, että voittojen lisääminen toimii
        assertEquals(0, pelaaja.haeVoitot());
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.haeVoitot());
    }

    @Test
    void testHaeVoitot() {
        Pelaaja pelaaja = new Pelaaja();

        // Testaa, että pelaajan voittojen hakeminen toimii
        assertEquals(0, pelaaja.haeVoitot());
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.haeVoitot());
    }
}


