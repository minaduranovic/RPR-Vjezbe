package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    File file;
    ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        ArrayList<Laptop> postojeci = vratiPodatkeIzDatoteke();

        postojeci.add(laptop);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, postojeci);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        if (file.exists()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
