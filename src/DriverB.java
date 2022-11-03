import transport.Car;

public class DriverB<D extends Car> extends Driver {


    public DriverB(String name, int yearOfGettingLicense) {
        super(name, yearOfGettingLicense);

    }

    public void start(D car) {
        System.out.println(getName() + " начал движение на " + car.getBrand());
    }

    public void stop() {
        System.out.println(getName() + " остановился");
    }

    public void refill() {
        System.out.println(getName() + " заправился");
    }

}