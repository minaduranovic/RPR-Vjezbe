package ba.unsa.etf.rpr;

import java.io.File;

public class Main {
    public static void main(String[] args){


                LaptopDaoSerializableFile serializableFileDao = new LaptopDaoSerializableFile(new File("laptopi.txt"));
                LaptopDaoJSONFile jsonFileDao = new LaptopDaoJSONFile(new File("laptopi.json"));
                LaptopDaoXMLFile xmlFileDao = new LaptopDaoXMLFile(new File("laptopi.xml"));
//
                serializableFileDao.dodajLaptopUListu(new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3));
                jsonFileDao.dodajLaptopUListu(new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6));
                xmlFileDao.dodajLaptopUListu(new Laptop("Apple", "MacBook Pro", 2000.0, 32, 512, 0, "Apple M1", "Apple M1", 13.3));

//                serializableFileDao.dodajLaptopUFile(new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3));
//                jsonFileDao.dodajLaptopUFile(new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6));
//                xmlFileDao.dodajLaptopUFile(new Laptop("Apple", "MacBook Pro", 2000.0, 32, 512, 0, "Apple M1", "Apple M1", 13.3));


                try {
                    Laptop laptop1 = serializableFileDao.getLaptop("Intel i7");
                    System.out.println("Laptop 1: " + laptop1);

                    Laptop laptop2 = jsonFileDao.getLaptop("AMD Ryzen 5");
                    System.out.println("Laptop 2: " + laptop2);

                    Laptop laptop3 = xmlFileDao.getLaptop("Apple M1");
                    System.out.println("Laptop 3: " + laptop3);
                } catch (NeodgovarajuciProcesorException e) {
                    System.out.println(e.getMessage());
                }

//                serializableFileDao.napuniListu(serializableFileDao.vratiPodatkeIzDatoteke());
//                jsonFileDao.napuniListu(jsonFileDao.vratiPodatkeIzDatoteke());
//                xmlFileDao.napuniListu(xmlFileDao.vratiPodatkeIzDatoteke());
            }



}
