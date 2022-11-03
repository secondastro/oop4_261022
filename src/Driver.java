import transport.Transport;

public abstract class Driver<C extends Transport> {
    private String name;

    private int licenseAge;

    private String licenseType;

    public Driver(String name, int yearOfGettingLicense) {
        this.name = ValidationUtils.validationString(name, "default");
        this.licenseAge = ValidationUtils.validationAge(yearOfGettingLicense);
        if (this.getClass() == DriverB.class) {
            this.licenseType = "Категория B";
        } else if (this.getClass()==DriverC.class) {
            this.licenseType = "Категория C";
        } else if (this.getClass() == DriverD.class) {
            this.licenseType = "Категория D";
        }
    }
    public void stop() {
        System.out.println(getName() + " остановился");
    }

    public void refill() {
        System.out.println(getName() + " заправился");
    }

//    public abstract void start(C transport) ;
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
}