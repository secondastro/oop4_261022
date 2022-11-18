package transport;

import personal.DriverC;
import utils.WrongTestDriveException;


public class Bus extends Transport implements Competing {

    private DriverC driver;

    public enum PassCapacity{XS(0,10),
        S(10,25),
        M(40,50),
        L(60,80),
        XL(100,120);
    private final int capacityMin;
    private final int capacityMax;

        PassCapacity(int capacityMin, int capacityMax) {
            this.capacityMin = capacityMin;
            this.capacityMax = capacityMax;
        }

        public int getCapacityMin() {
            return capacityMin;
        }

        public int getCapacityMax() {
            return capacityMax;
        }


        @Override
        public String toString() {
            return "вместимость: от " + getCapacityMin() + " до " + getCapacityMax() + " человек";
        }
    }

    private final PassCapacity passCapacity;
    public Bus(String brand, String model, double engineVolume, double time, int speed, PassCapacity passCapacity) {
        super(brand, model, engineVolume, time, speed);
        this.passCapacity = passCapacity;
    }

    public DriverC getDriver() {
        return driver;
    }

    public void setDriver(DriverC driver) {
        this.driver = driver;
    }

    @Override
    public void printType() {
        if (this.passCapacity != null) {
            System.out.println(this.passCapacity);
        }else {
            System.out.println("Информации недостаточно");
        }

    }
    @Override
    public void printPersonalData() {
        super.printPersonalData();
        System.out.println(
                ", Водитель " + getDriver().getName());
    }
    @Override
    public void start() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void finish() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " закончил движение");
    }

    @Override
    public void checkTest() throws WrongTestDriveException {
        throw new WrongTestDriveException("Автобусу " + getBrand() + " " + getModel() + " диагностика не требуется");
    }

    @Override
    public String pitStop() {
        return getBrand() + " " + getModel() + " заехал на пит-стоп";
    }

    @Override
    public String maxSpeed() {
        return "Максимальная скорость автобуса " + getBrand() + " " + getModel() + ": " + getSpeed() + " км/ч";


    }

    public String BestTime() {
        return "Автобус " + getBrand() + " " + getModel() + ". Лучшее время круга: " + getTime() + " секунд";
    }
}
