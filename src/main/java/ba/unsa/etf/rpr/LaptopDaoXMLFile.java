package ba.unsa.etf.rpr;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    File file;
    ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {

        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(file, laptop);
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
        ArrayList<Laptop> lista = new ArrayList<>();
        int ch;
        FileReader fr = null;
        String result = "";
        try {
            fr = new FileReader("laptopi.xml");
            while ((ch = fr.read()) != -1)
                result = result + (char) ch;
            XmlMapper objectMapper = new XmlMapper();
            try {
                Laptop laptop = objectMapper.readValue(result, Laptop.class);
                lista.add(laptop);
            } catch (IOException e) {
                e.printStackTrace();
                ;
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return lista;

    }
}
