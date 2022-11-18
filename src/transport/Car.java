package transport;

import personal.DriverB;
import utils.WrongTestDriveException;


public class Car extends Transport implements Competing {

    private DriverB driver;
    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хэтчбэк"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        OUTLANDER("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        FURGON("Фургон"),
        MINIVAN("Минивен");
        private final String name;

        BodyType(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "тип кузова: " +
                    this.name;
        }
    }

    private final BodyType bodyType;

    public Car(String brand, String model, double engineVolume, double time, int speed, BodyType bodyType) {
        super(brand, model, engineVolume, time, speed);
        this.bodyType = bodyType;
//        setDriver(driver);
    }

    public void setDriver(DriverB driver) {
        this.driver = driver;
    }

    public DriverB getDriver() {
        return driver;
    }

    @Override
    public void printType() {
        if (this.bodyType != null)
            System.out.println(this.bodyType);
        else {
            System.out.println("Информации не достаточно");
        }
    }

    @Override
    public void start() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void finish() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " закончил движение");
    }

    @Override
    public void printPersonalData() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() +
                ", Водитель " + getDriver().getName() + ". Спонсоры " + getSponsors()  + ", механики " + getMechanics().toString());
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
            throw new WrongTestDriveException("!!!Автомобиль " + getBrand() + " " + getModel() + " не прошел диагностику!!!");
        }
    }


    @Override
    public String pitStop() {
        return getBrand() + " " + getModel() + " заехал на пит-стоп";
    }

    @Override
    public String maxSpeed() {
        return "Максимальная скорость автомобиля " + getBrand() + " " + getModel() + ": " + getSpeed() + " км/ч";


    }

    public String BestTime() {
        return "Автомобиль " + getBrand() + " " + getModel() + ". Лучшее время круга: " + getTime() + " секунд";
    }
}