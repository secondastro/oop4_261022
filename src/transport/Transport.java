package transport;

import personal.Driver;
import personal.Mechanic;
import personal.Sponsor;
import utils.WrongTestDriveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Transport {

    public static int counter = 0;
    private final String brand;
    private final String model;
    private final double engineVolume;
    private final double time;
    private final int speed;

    private final List<Driver<?>> drivers = new ArrayList<>();
    private final List<Sponsor> sponsors = new ArrayList<>();

    private final List<Mechanic> mechanics = new ArrayList<>();

    private int money;

    public static List<Transport> allTransports = new ArrayList<>(15);
    public static List<Transport> testedTransports = new ArrayList<>();

    public String s = null;


    public Transport(String brand, String model, double engineVolume, double time, int speed) {
        this.brand = Objects.requireNonNullElse(brand, "default");
        this.model = Objects.requireNonNullElse(model, "default");
        if (engineVolume == 0) {
            this.engineVolume = 1.6;
        } else {
            this.engineVolume = engineVolume;
        }
        this.time = time;
        this.speed = speed;
        allTransports.add(this);
    }

    public abstract void printType();

    public abstract void start();

    public abstract void finish();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public double getTime() {
        return time;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List getMechanics() {
        return this.mechanics;
    }

    public void setMechanics(Mechanic mechanic) {
        this.mechanics.add(mechanic);
    }

    public List getSponsors() {
        return this.sponsors;
    }

    public void setSponsors(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }

    public void printPersonalData() {
        System.out.print("Автомобиль " + getBrand() + " " + getModel() + ". Спонсоры " + getSponsors() + ", механики " + getMechanics().toString());
    }

    public static void transportTest(Transport... transports) {
        for (Transport transport : transports) {
            testedTransports.add(transport);
        }
    }

    public abstract void checkTest() throws WrongTestDriveException;


    @Override
    public String toString() {
        return ("Автомобиль " + getBrand() + " " + getModel() + ". Спонсоры " + getSponsors() + ", механики " + getMechanics().toString());
    }

}
