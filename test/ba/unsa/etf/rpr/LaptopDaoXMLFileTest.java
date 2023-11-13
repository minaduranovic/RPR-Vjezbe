package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LaptopDaoXMLFileTest {

    private LaptopDaoXMLFile laptopDao;
    private File file;

    @BeforeEach
    void setUp() {
        // Postavite file pre svakog testa
        file = new File("test.xml");
        laptopDao = new LaptopDaoXMLFile(file);
    }

    @AfterEach
    void tearDown() {
        // Očistite resurse, npr. izbrišite datoteku
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void dodajLaptopUListu() {
        Laptop laptop = new Laptop("Brand", "Model", 1000.0, 8, 512, 256, "Procesor", "Graficka", 15.6);
        laptopDao.dodajLaptopUListu(laptop);
        assertEquals(1, laptopDao.laptopi.size());
        assertEquals(laptop, laptopDao.laptopi.get(0));
    }
    //// nisu dobre metode dodajLapotopUFile i vratiPodatkeIzDatoteke
    @Test
    void dodajLaptopUFile() throws IOException, NoSuchFieldException, IllegalAccessException {
        Laptop laptop = new Laptop("Brand", "Model", 1000.0, 8, 512, 256, "Procesor", "Graficka", 15.6);

        // Mock XmlMapper
        XmlMapper xmlMapperMock = mock(XmlMapper.class);
        doAnswer(invocation -> {
            // Ovde možete dodati kod koji treba izvršiti kada se pozove writeValue
            return null;
        }).when(xmlMapperMock).writeValue(any(File.class), any(ArrayList.class));

        // Korišćenje refleksije da postavimo mock objekat kao zamenu
        Field field = LaptopDaoXMLFile.class.getDeclaredField("xmlMapper");
        field.setAccessible(true);
        field.set(laptopDao, xmlMapperMock);

        try {
            laptopDao.dodajLaptopUFile(laptop);
        } finally {
            // Vratite stvarni XmlMapper nakon izvršavanja testa
            field.set(laptopDao, new XmlMapper());
        }

        // Provera da li je metoda writeValue pozvana
        verify(xmlMapperMock).writeValue(eq(file), any(ArrayList.class));
    }


    @Test
    void getLaptop() {
        Laptop laptop = new Laptop("Brand", "Model", 1000.0, 8, 512, 256, "Procesor", "Graficka", 15.6);
        laptopDao.laptopi.add(laptop);

        assertEquals(laptop, laptopDao.getLaptop("Procesor"));
    }

    @Test
    void napuniListu() {
        ArrayList<Laptop> lista = new ArrayList<>();
        lista.add(new Laptop("Brand", "Model", 1000.0, 8, 512, 256, "Procesor", "Graficka", 15.6));
        laptopDao.napuniListu(lista);

        assertEquals(lista, laptopDao.laptopi);
    }
    @Test
    void vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> lista = new ArrayList<>();
        lista.add(new Laptop("Brand", "Model", 1000.0, 8, 512, 256, "Procesor", "Graficka", 15.6));

        // Mock konstrukciju XmlMapper
        try (MockedConstruction<XmlMapper> mockedConstruction = mockConstruction(XmlMapper.class, (mock, context) -> {
            when(mock.readValue(eq(file), any(TypeReference.class))).thenReturn(lista);
        })) {
            ArrayList<Laptop> rezultat = laptopDao.vratiPodatkeIzDatoteke();
            assertEquals(lista, rezultat);
        }
    }

}