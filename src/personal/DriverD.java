package personal;

import transport.Truck;

public class DriverD extends  Driver<Truck>{


    public DriverD(String name, int yearOfGettingLicense) {
        super(name, yearOfGettingLicense);

    }

//    public void start(D truck) {
//        System.out.println(getName() + " начал движение на " + truck.getBrand());
//    }

//    public void stop() {
//        System.out.println(getName() + " остановился");
//    }
//
//    public void refill() {
//        System.out.println(getName() + " заправился");
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = ValidationUtils.validationString(name, "default");
//    }
//
//    public int getLicenseAge() {
//        return licenseAge;
//    }
//
//    public void setLicenseAge(int licenseAge) {
//        this.licenseAge = ValidationUtils.validationAge(licenseAge);
//    }
//
//    public String getLicenseType() {
//        return licenseType;
//    }
}