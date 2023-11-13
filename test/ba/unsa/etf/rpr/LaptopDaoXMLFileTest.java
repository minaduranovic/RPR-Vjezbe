package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoXMLFileTest {

    @Test
    void dodajLaptopUListuTest() {
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(new File("test.xml"));
        Laptop laptop = new Laptop("Brand1", "Model1", 1000.0, 8, 500, 256, "Procesor1", "Graficka1", 15.6);

        laptopDao.dodajLaptopUListu(laptop);
        assertEquals(1, laptopDao.laptopi.size());
        assertEquals(laptop, laptopDao.laptopi.get(0));
    }

    @Test
    void dodajLaptopUFileTest() {
        File testFile = new File("test.xml");
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(testFile);
        Laptop laptop = new Laptop("Brand1", "Model1", 1000.0, 8, 500, 256, "Procesor1", "Graficka1", 15.6);

        laptopDao.dodajLaptopUFile(laptop);
        assertTrue(testFile.exists());

        // Dodatni testovi moguće su provere da li su podaci zapravo upisani u datoteku
    }

    @Test
    void getLaptopTest() {
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(new File("test.xml"));
        Laptop laptop = new Laptop("Brand1", "Model1", 1000.0, 8, 500, 256, "Procesor1", "Graficka1", 15.6);
        laptopDao.dodajLaptopUListu(laptop);

        assertEquals(laptop, laptopDao.getLaptop("Procesor1"));
    }

    @Test
    void napuniListuTest() {
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(new File("test.xml"));
        ArrayList<Laptop> lista = new ArrayList<>();
        lista.add(new Laptop("Brand1", "Model1", 1000.0, 8, 500, 256, "Procesor1", "Graficka1", 15.6));

        laptopDao.napuniListu(lista);
        assertEquals(lista, laptopDao.laptopi);
    }

    @Test
    void vratiPodatkeIzDatotekeTest() {
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(new File("test.xml"));
        ArrayList<Laptop> lista = new ArrayList<>();
        lista.add(new Laptop("Brand1", "Model1", 1000.0, 8, 500, 256, "Procesor1", "Graficka1", 15.6));
        laptopDao.napuniListu(lista);

        ArrayList<Laptop> listaIzDatoteke = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(lista, listaIzDatoteke);
    }
}
