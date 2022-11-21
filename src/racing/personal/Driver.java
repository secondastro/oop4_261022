package racing.personal;

import racing.transport.Transport;
import utils.DriverLicenseException;
import utils.ValidationUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Driver<C extends Transport> {
    private String name;

    private int licenseAge;

    private String licenseType;

    public static final Set<Driver> allDrivers = new HashSet<>();

    public Driver(String name, int yearOfGettingLicense) {
        this.name = ValidationUtils.validationString(name, "Empty");
        this.licenseAge = ValidationUtils.validationAge(yearOfGettingLicense);
        if (this.getClass() == DriverB.class) {
            this.licenseType = "Категория B";
        } else if (this.getClass() == DriverC.class) {
            this.licenseType = "Категория C";
        } else if (this.getClass() == DriverD.class) {
            this.licenseType = "Категория D";
        }
        if (allDrivers.contains(this)) {
            throw new RuntimeException(getName() + " уже выехал на другом автомобиле");
        } else {
            allDrivers.add(this);
        }
    }

    public void start(C car) {
        System.out.println(getName() + " начал движение на " + car.getBrand());
    }

    public void stop() {
        System.out.println(getName() + " остановился");
    }

    public void refill() {
        System.out.println(getName() + " заправился");
    }

//    public abstract void start(C racing.transport) ;
//
//    public abstract void stop();
//
//    public  abstract  void refill() ;

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

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }


    public void checkLicense() throws DriverLicenseException {
        if (getClass() == DriverB.class) {
            if (!Objects.equals(getLicenseType(), "Категория B")) {
                throw new DriverLicenseException("Необходимо указать тип прав!");
            }
        }
        if (getClass() == DriverC.class) {
            if (!Objects.equals(getLicenseType(), "Категория C")) {
                throw new DriverLicenseException("Необходимо указать тип прав!");
            }
        }
        if (getClass() == DriverD.class) {
            if (!Objects.equals(getLicenseType(), "Категория D")) {
                throw new DriverLicenseException("Необходимо указать тип прав!");
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver<?> driver = (Driver<?>) o;
        return licenseAge == driver.licenseAge && name.equals(driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, licenseAge);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", licenseAge=" + licenseAge +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }
}
