package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoJSONFileTest {
    private LaptopDaoJSONFile laptopDao;
    private static final String test = "testLaptops.json";

    @BeforeEach
    void setUp() {
        File testFile = new File( test);

        laptopDao = new LaptopDaoJSONFile(testFile);

        if (testFile.exists()) {
            assertTrue(testFile.delete());
        }
    }

    @Test
    void dodajLaptopUListu() {
        Laptop laptop = new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3);
        laptopDao.dodajLaptopUListu(laptop);

        assertEquals(1, laptopDao.laptopi.size());
        assertEquals(laptop, laptopDao.laptopi.get(0));
    }
//// nisu dobre metode dodajLapotopUFile i vratiPodatkeIzDatoteke

    @Test
    void dodajLaptopUFile() {
        Laptop laptop1 = new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6);

        laptopDao.dodajLaptopUFile(laptop1);
        laptopDao.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> laptopsFromFile = laptopDao.vratiPodatkeIzDatoteke();

        assertEquals(2, laptopsFromFile.size());
        assertTrue(laptopsFromFile.contains(laptop1));
        assertTrue(laptopsFromFile.contains(laptop2));
    }

    @Test
    void getLaptop() {
        Laptop laptop1 = new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6);

        laptopDao.laptopi.addAll(Arrays.asList(laptop1, laptop2));

        assertEquals(laptop1, laptopDao.getLaptop("Intel i7"));
        assertEquals(laptop2, laptopDao.getLaptop("AMD Ryzen 5"));
    }

    @Test
    void napuniListu() {
        Laptop laptop1 = new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6);

        ArrayList<Laptop> laptops = new ArrayList<>(Arrays.asList(laptop1, laptop2));

        laptopDao.napuniListu(laptops);

        assertEquals(2, laptopDao.laptopi.size());
        assertTrue(laptopDao.laptopi.contains(laptop1));
        assertTrue(laptopDao.laptopi.contains(laptop2));
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        Laptop laptop1 = new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6);

        ArrayList<Laptop> laptops = new ArrayList<>(Arrays.asList(laptop1, laptop2));

        try {
            laptopDao.dodajLaptopUFile(laptop1);
            laptopDao.dodajLaptopUFile(laptop2);

            ArrayList<Laptop> laptopsFromFile = laptopDao.vratiPodatkeIzDatoteke();

            assertEquals(2, laptopsFromFile.size());
            assertTrue(laptopsFromFile.contains(laptop1));
            assertTrue(laptopsFromFile.contains(laptop2));
        } catch (Exception e) {
            fail("Exception thrown during serialization: " + e.getMessage());
        }
    }
}
