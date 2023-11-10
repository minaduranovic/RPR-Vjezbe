package ba.unsa.etf.rpr;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Laptop implements Serializable {
    private String brand;
    private  String model;
    private double cijena;
    private int ram;
    private int hdd;
    private int ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;

    public Laptop(
            @JsonProperty("brand") String brand,
            @JsonProperty("model") String model,
            @JsonProperty("cijena") double cijena,
            @JsonProperty("ram") int ram,
            @JsonProperty("hdd") int hdd,
            @JsonProperty("ssd") int ssd,
            @JsonProperty("procesor") String procesor,
            @JsonProperty("grafickaKartica") String grafickaKartica,
            @JsonProperty("velicinaEkrana") double velicinaEkrana
    ) {
        this.brand = brand;
        this.model = model;
        this.cijena = cijena;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.velicinaEkrana = velicinaEkrana;
    }
//    public Laptop(String brand, String model, double cijena, int ram, int hdd, int ssd, String procesor, String grafickaKartica, double velicinaEkrana) {
//        this.brand = brand;
//        this.model = model;
//        this.cijena = cijena;
//        this.ram = ram;
//        this.hdd = hdd;
//        this.ssd = ssd;
//        this.procesor = procesor;
//        this.grafickaKartica = grafickaKartica;
//        this.velicinaEkrana = velicinaEkrana;
//    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(getCijena(), laptop.getCijena()) == 0 && getRam() == laptop.getRam() && getHdd() == laptop.getHdd() && getSsd() == laptop.getSsd() && Double.compare(getVelicinaEkrana(), laptop.getVelicinaEkrana()) == 0 && Objects.equals(getBrand(), laptop.getBrand()) && Objects.equals(getModel(), laptop.getModel()) && Objects.equals(getProcesor(), laptop.getProcesor()) && Objects.equals(getGrafickaKartica(), laptop.getGrafickaKartica());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getCijena(), getRam(), getHdd(), getSsd(), getProcesor(), getGrafickaKartica(), getVelicinaEkrana());
    }
}
