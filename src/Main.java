import transport.*;

import static transport.Transport.transportTest;

public class Main {
    public static void main(String[] args) throws DriverLicenseException {
        Car audi = new Car("Audi",
                "A8 50 L TDI quattro",
                3.0,
                new Transport.Circles(new double[]{124.55, 126.76, 110.0}, new int[]{190, 188, 192}), Car.BodyType.SEDAN);
        Car bmw = new Car("BMW",
                "Z8",
                3.0,
                new Transport.Circles(new double[]{114.65, 113.44, 112.45}, new int[]{210, 242, 251}), Car.BodyType.CROSSOVER);
        Car kia = new Car("Kia",
                "Sportage 4-го поколения",
                2.4,
                new Transport.Circles(new double[]{143.56, 155.55, 151.31}, new int[]{190, 200, 210}), Car.BodyType.HATCHBACK);
        Car hyundai = new Car("Hyundai",
                "Avante",
                1.6,
                new Transport.Circles(new double[]{144.44, 142.22, 134.44}, new int[]{200, 220, 215}), Car.BodyType.OUTLANDER);

        bmw.start();
        System.out.println(bmw.BestTime());
        System.out.println(bmw.pitStop());
        System.out.println(bmw.maxSpeed());
        bmw.finish();
        System.out.println();

        Bus mercedes = new Bus("Mercedes",
                "Sprinter",
                2.0,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}),
                Bus.PassCapacity.S);
        Bus paz = new Bus("ПАЗ",
                "001",
                3.0,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}),
                Bus.PassCapacity.L);
        Bus fiat = new Bus("Fiat",
                "Buss",
                2.5,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}),
                Bus.PassCapacity.M);
        Bus zil = new Bus("ЗИЛ",
                "АП43",
                1.9,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}),
                Bus.PassCapacity.XL);

        mercedes.start();
        System.out.println(mercedes.BestTime());
        System.out.println(mercedes.pitStop());
        System.out.println(mercedes.maxSpeed());
        mercedes.finish();
        System.out.println();

        Truck man = new Truck("MAN",
                "Expeditor",
                8.5,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}),
                Truck.LoadCapacity.N3);
        Truck kamaz = new Truck("КАМАЗ",
                "Комфорт",
                7.9,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}),
                Truck.LoadCapacity.N2);
        Truck scania = new Truck("Scania",
                "Future",
                9.0,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}),
                Truck.LoadCapacity.N3);
        Truck belaz = new Truck("Белаз",
                "Винтер",
                9.6,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}),
                Truck.LoadCapacity.N3);

        kamaz.start();
        System.out.println(kamaz.BestTime());
        System.out.println(kamaz.pitStop());
        System.out.println(kamaz.maxSpeed());
        kamaz.finish();

        DriverB aleks = new DriverB("Александр Варачев", 1999);
        aleks.start(audi);
        DriverC max = new DriverC("Макс Трайбер", 2010);
        max.start(fiat);
        DriverD vasilich = new DriverD("Василич", 1985);
        vasilich.start(belaz);
        max.stop();

        System.out.println(vasilich.getLicenseType());
        hyundai.printType();
        mercedes.printType();
        belaz.printType();

        System.out.println();
        vasilich.setLicenseType("gfgsdfhsdfg");
        checkLicense(aleks,max,vasilich);
        System.out.println();
        transportTest(audi, bmw, kia, mercedes, belaz, kamaz); //провожу диагностику данных транспортных средств, записываю в массив
        checkTest(audi,bmw,kia,hyundai,mercedes,fiat,paz,zil,kamaz,belaz,man,scania); //сверяю все объекты с массивом прошедших диагностику ТС

    }

    public static void checkLicense(Driver... drivers) {
        for (Driver driver : drivers) {
            try {
                driver.checkLicense();
            } catch (DriverLicenseException e) {
                System.out.println(driver.getName() + ": " + e.getMessage());
            }
        }
    }

    public static void checkTest(Transport... transports) {
        for (Transport transport : transports) {
            try{
                transport.checkTest();
            } catch (WrongTestDriveException e) {
                System.out.println(e.getMessage());;
            }
        }
    }

}