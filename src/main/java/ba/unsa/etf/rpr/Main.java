package ba.unsa.etf.rpr;

import java.io.File;

public class Main {
    public static void main(String[] args){


                LaptopDaoSerializableFile  serFile= new LaptopDaoSerializableFile(new File("laptopi.ser"));
                LaptopDaoJSONFile jsonFile= new LaptopDaoJSONFile(new File("laptopi.json"));
                LaptopDaoXMLFile xmlFile = new LaptopDaoXMLFile(new File("laptopi.xml"));
//
                serFile.dodajLaptopUListu(new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3));
                jsonFile.dodajLaptopUListu(new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6));
                xmlFile.dodajLaptopUListu(new Laptop("Apple", "MacBook Pro", 2000.0, 32, 512, 0, "Apple M1", "Apple M1", 13.3));

                serFile.dodajLaptopUFile(new Laptop("Dell", "XPS 13", 1500.0, 16, 512, 0, "Intel i7", "Integrated", 13.3));
//                jsonFile.dodajLaptopUFile(new Laptop("HP", "Pavilion", 800.0, 8, 1000, 256, "AMD Ryzen 5", "NVIDIA GTX 1650", 15.6));
//                xmlFile.dodajLaptopUFile(new Laptop("Apple", "MacBook Pro", 2000.0, 32, 512, 0, "Apple M1", "Apple M1", 13.3));
//

                try {
                    Laptop laptop1 = serFile.getLaptop("Intel i7");
                    System.out.println("Laptop 1: " + laptop1);

                    Laptop laptop2 = jsonFile.getLaptop("AMD Ryzen 5");
                    System.out.println("Laptop 2: " + laptop2);

                    Laptop laptop3 = xmlFile.getLaptop("Apple M1");
                    System.out.println("Laptop 3: " + laptop3);
                } catch (NeodgovarajuciProcesorException e) {
                    System.out.println(e.getMessage());
                }

                serFile.napuniListu(serFile.vratiPodatkeIzDatoteke());
//                jsonFile.napuniListu(jsonFile.vratiPodatkeIzDatoteke());
//                xmlFile.napuniListu(xmlFile.vratiPodatkeIzDatoteke());

            }



}
