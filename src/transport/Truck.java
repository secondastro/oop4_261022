package transport;

import personal.DriverD;
import utils.WrongTestDriveException;


public class Truck extends Transport implements Competing {

    private DriverD driver;
    public enum LoadCapacity {
        N1(null, 3.5f),
        N2(3.5f, 12f),
        N3(12f, null);
        private final Float capacityMin;
        private final Float capacityMax;

        public Float getCapacityMin() {
            return capacityMin;
        }

        public float getCapacityMax() {
            return capacityMax;
        }

        LoadCapacity(Float capacityMin, Float capacityMax) {
            this.capacityMin = capacityMin;
            this.capacityMax = capacityMax;
        }

        @Override
        public String toString() {
            String capacityPassMin = capacityMin != null
                    ? "от " + capacityMin
                    : "";
            String capacityPassMax = capacityMax != null
                    ? " до " + capacityMax : "";
            return "грузоподъемность: " + capacityPassMin + capacityPassMax + " тонн";
        }
    }

    private final LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineVolume, double time, int speed, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, time, speed);
        this.loadCapacity = loadCapacity;
    }

    public DriverD getDriver() {
        return driver;
    }

    public void setDriver(DriverD driver) {
        this.driver = driver;
    }

    @Override
    public void printType() {
        if (this.loadCapacity != null) {
            System.out.println(this.loadCapacity);
        } else {
            System.out.println("Информации не достаточно");
        }

    }

    @Override
    public void printPersonalData() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() +
                ", Водитель " + getDriver().getName() + ". Спонсоры " + getSponsors()  + ", механики " + getMechanics().toString());
    }

    @Override
    public void start() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void finish() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " закончил движение");
    }

    @Override
    public void checkTest() throws WrongTestDriveException {
        s = null;
        for (Transport testedTransport : testedTransports) {
            if (this == testedTransport) {
                System.out.println(s = this.getBrand() + " " + this.getModel() + " прошел диагностику");
            }
        }
        if (s == null) {
            throw new WrongTestDriveException("!!!Грузовик " + getBrand() + " " + getModel() + " не прошел диагностику!!!");
        }
    }


    @Override
    public String pitStop() {
        return getBrand() + " " + getModel() + " заехал на пит-стоп";
    }

    @Override
    public String maxSpeed() {

        return "Максимальная скорость грузовика " + getBrand() + " " + getModel() + ": " +  getSpeed() + " км/ч";


    }

    public String BestTime() {

        return "Грузовик " + getBrand() + " " + getModel() + ". Лучшее время круга: " + getTime() + " секунд";
    }
}

