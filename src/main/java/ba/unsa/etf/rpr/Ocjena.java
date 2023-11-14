package ba.unsa.etf.rpr;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        setOcjena(ocjena);
    }

    // Get i set metode za osobu
    public LicneInformacije getOsoba() {
        return osoba;
    }

    public void setOsoba(LicneInformacije osoba) {
        this.osoba = osoba;
    }

    // Get i set metode za ocjenu
    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        if (ocjena > 0 && ocjena <= 10) {
            this.ocjena = ocjena;
        } else {
            System.out.println("Neispravna ocjena. Ocjena mora biti između 1 i 10.");
        }
    }
}
