package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {

    private LaptopDaoSerializableFile laptopDao;
    private File testFile;

    @BeforeEach
    void setUp() {
        testFile = new File("testFile.ser");
        laptopDao = new LaptopDaoSerializableFile(testFile);
    }

    @Test
    void dodajLaptopUListu() {
        Laptop laptop = new Laptop("Brand1", "Model1", 1500.0, 8, 1000, 256, "Procesor1", "Graficka1", 15.6);
        laptopDao.dodajLaptopUListu(laptop);
        assertEquals(1, laptopDao.laptopi.size());
        assertEquals(laptop, laptopDao.laptopi.get(0));
    }

    @Test
    void dodajLaptopUFile() {
        Laptop laptop = new Laptop("Brand2", "Model2", 2000.0, 16, 2000, 512, "Procesor2", "Graficka2", 17.3);

        laptopDao.dodajLaptopUFile(laptop);

        assertTrue(laptopDao.vratiPodatkeIzDatoteke().contains(laptop));
    }

    @Test
    void getLaptop() {
        Laptop laptop = new Laptop("Brand3", "Model3", 1200.0, 8, 500, 128, "Procesor3", "Graficka3", 14.0);
        laptopDao.dodajLaptopUListu(laptop);

        try {
            assertEquals(laptop, laptopDao.getLaptop("Procesor3"));
        } catch (NeodgovarajuciProcesorException e) {
            fail("Ne bi trebalo baciti izuzetak");
        }
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> laptopi = new ArrayList<>();
        laptopi.add(new Laptop("Brand6", "Model6", 1600.0, 16, 500, 256, "Procesor6", "Graficka6", 17.3));
        laptopi.add(new Laptop("Brand7", "Model7", 2200.0, 8, 1000, 128, "Procesor7", "Graficka7", 15.6));

        laptopDao.napuniListu(laptopi);

        assertEquals(laptopi, laptopDao.vratiPodatkeIzDatoteke());
    }


}
