import transport.Bus;
import transport.Competing;

public class DriverC<D extends Bus & Competing> {

    private String name;

    private int licenseAge;

    private final String licenseType = "Категория C";

    public DriverC(String name, int yearOfGettingLicense) {
        this.name = ValidationUtils.validationString(name, "default");
        this.licenseAge = ValidationUtils.validationAge(yearOfGettingLicense);
        //setLicenseType(transport);
    }

    public void start(D bus) {
        System.out.println(getName() + " начал движение на " + bus.getBrand());
    }

    public void stop() {
        System.out.println(getName() + " остановился");
    }

    public void refill() {
        System.out.println(getName() + " заправился");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = ValidationUtils.validationString(name, "default");
    }

    public int getLicenseAge() {
        return licenseAge;
    }

    public void setLicenseAge(int licenseAge) {
        this.licenseAge = ValidationUtils.validationAge(licenseAge);
    }

    public String getLicenseType() {
        return licenseType;
    }
}