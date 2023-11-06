package ba.unsa.etf.rpr;

import java.util.ArrayList;

public interface LaptopDao {

    public void dodajLaptopUListu(Laptop laptop);
    public void dodajLaptopUFile(Laptop laptop);
    public void  getLaptop(String procesor);
    public void  napuniListu(ArrayList<Laptop> laptopi);
    public void  vratiPodatkeIzDatoteke();
}
