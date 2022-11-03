import transport.Transport;

public abstract class Driver<C extends Transport>{
    private String name;

    private int licenseAge;

    private String licenseType;

    public Driver (String name, int yearOfGettingLicense) {
        this.name = ValidationUtils.validationString(name, "default");
        this.licenseAge = ValidationUtils.validationAge(yearOfGettingLicense);
        //setLicenseType(transport);
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

//    public String getLicenseType() {
//        switch (getClass().toString().contains(""));
    }