package racing.personal;

import racing.transport.Bus;

public class DriverC extends Driver<Bus> {


    public DriverC(String name, int yearOfGettingLicense) {
        super(name, yearOfGettingLicense);
    }


//    public void start(D bus) {
//        System.out.println(getName() + " начал движение на " + bus.getBrand());
//    }


//
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