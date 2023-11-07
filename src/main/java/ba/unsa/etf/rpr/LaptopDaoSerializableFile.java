package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile  implements Serializable, LaptopDao {
   private  File file;
   private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file) {
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

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            postojeci.add(laptop);

            outputStream.writeObject(postojeci);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
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
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                return (ArrayList<Laptop>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
