package Kladd;

public class Car {
    String merke;
    int alder;
    int kilometer;

    Car(String m, int a, int km) {
        this.merke = m;
        this.alder = a;
        this.kilometer = km;
    }

    String getBrand() {
        return this.merke;
    }

    int getAge() {
        return this.alder;
    }

    double getKm() {
        return this.kilometer;
    }

    @Override
    public String toString() {
        return merke;
    }
}
