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

    private final List<Sponsor> sponsors = new ArrayList<>();

    private final List<Mechanic> mechanics = new ArrayList<>();

    private int money;


    public static Transport[] testedTransports = new Transport[0];


    public String s =null;
    public static List<Transport> allTransports = new ArrayList<>(15);


    public Transport(String brand, String model, double engineVolume,double time, int speed) {
        this.brand = Objects.requireNonNullElse(brand, "default");
        this.model = Objects.requireNonNullElse(model, "default");
        if (engineVolume == 0) {
            this.engineVolume = 1.6;
        } else {
            this.engineVolume = engineVolume;
        }
        this.time = time;
        this.speed = speed;
        counter++;
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

    public void setSponsors (Sponsor sponsor) {
        this.sponsors.add(sponsor) ;
    }

    public void printPersonalData() {
        System.out.print("Автомобиль " + getBrand() + " " + getModel() + ". Спонсоры " + getSponsors()  + ", механики " + getMechanics().toString());
    }

    public static void transportTest(Transport... transports) {
        for (int i = 0; i < transports.length; i++) {
            if (counter == 0) {
                testedTransports = new Transport[1];
                testedTransports[0] = transports[i];
                counter++;
            } else {
                counter++;
                testedTransports = Arrays.copyOf(testedTransports, counter);
                testedTransports[counter - 1] = transports[i];
            }
        }
    }
    public abstract void checkTest() throws WrongTestDriveException;


    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }

}
