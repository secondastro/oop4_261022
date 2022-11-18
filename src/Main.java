import personal.*;
import transport.*;
import utils.DriverLicenseException;
import utils.WrongTestDriveException;

import static personal.Driver.allDrivers;

public class Main {
    public static void main(String[] args) {


        Car audi = new Car("Audi",
                "A8 50 L TDI quattro",
                3.0,
                115.1, 199, Car.BodyType.SEDAN);
        Car bmw = new Car("BMW",
                "Z8",
                3.0,
                114.65, 210, Car.BodyType.CROSSOVER);
        Car kia = new Car("Kia",
                "Sportage 4-го поколения",
                2.4,
                143.56, 200, Car.BodyType.HATCHBACK);
//        allRacers.add(audi);
        Car hyundai = new Car("Hyundai",
                "Avante",
                1.6,
                144.44, 220, Car.BodyType.OUTLANDER);

//        bmw.start();
//        System.out.println(bmw.BestTime());
//        System.out.println(bmw.pitStop());
//        System.out.println(bmw.maxSpeed());
//        bmw.finish();
        System.out.println();

        Bus mercedes = new Bus("Mercedes",
                "Sprinter",
                2.0,
                211.44, 189,
                Bus.PassCapacity.S);
        Bus paz = new Bus("ПАЗ",
                "001",
                3.0,
                211.44, 191,
                Bus.PassCapacity.L);
        Bus fiat = new Bus("Fiat",
                "Buss",
                2.5,
                213.44, 189,
                Bus.PassCapacity.M);
        Bus zil = new Bus("ЗИЛ",
                "АП43",
                1.9,
                211.44, 191,
                Bus.PassCapacity.XL);

//        mercedes.start();
//        System.out.println(mercedes.BestTime());
//        System.out.println(mercedes.pitStop());
//        System.out.println(mercedes.maxSpeed());
//        mercedes.finish();
//        System.out.println();

        Truck man = new Truck("MAN",
                "Expeditor",
                8.5,
                313.10, 177,
                Truck.LoadCapacity.N3);
        Truck kamaz = new Truck("КАМАЗ",
                "Комфорт",
                7.9,
                311.44, 176,
                Truck.LoadCapacity.N2);
        Truck scania = new Truck("Scania",
                "Future",
                9.0,
                310.19, 189,
                Truck.LoadCapacity.N3);
        Truck belaz = new Truck("Белаз",
                "Винтер",
                9.6,
                313.10, 189,
                Truck.LoadCapacity.N3);

//        kamaz.start();
//        System.out.println(kamaz.BestTime());
//        System.out.println(kamaz.pitStop());
//        System.out.println(kamaz.maxSpeed());
//        kamaz.finish();

//        hyundai.printType();
//        mercedes.printType();
//        belaz.printType();
//
//        System.out.println();
//        transportTest(audi, bmw, kia, mercedes, belaz, kamaz); //провожу диагностику данных транспортных средств, записываю в массив
//        checkTest(audi,bmw,kia,hyundai,mercedes,fiat,paz,zil,kamaz,belaz,man,scania); //сверяю все объекты с массивом прошедших диагностику ТС

        audi.setDriver(new DriverB("Алексей Иванов", 1966));
        bmw.setDriver(new DriverB("Иван Алексеев", 1999));
        kia.setDriver(new DriverB("Роман Косицын", 2005));
        hyundai.setDriver(new DriverB("Ахмед Ахмедов", 2009));

        mercedes.setDriver(new DriverC("Игорь Барбасов", 1988));
        fiat.setDriver(new DriverC("Ольга Карасева", 2006));
        paz.setDriver(new DriverC("Виктор Керагазов", 1974));
        zil.setDriver(new DriverC("Юлия Кивилёва", 2003));

        kamaz.setDriver(new DriverD("Никита Кукота", 2010));
        man.setDriver(new DriverD("Валерий Карелий", 2013));
        scania.setDriver(new DriverD("Павел Пиво", 2015));
        belaz.setDriver(new DriverD("Сахимджон Иванчук", 1997));

        System.out.println(allDrivers);

        Sponsor carPrice = new Sponsor("Компания CarPrice", 50000);
        Sponsor kam_az = new Sponsor("КАМАЗ", 100000);
        Sponsor stas = new Sponsor("Стас Михайлов", 75000);

        carPrice.toDonat(audi, bmw, kia, hyundai);
        kam_az.toDonat(man, scania, kamaz, belaz);
        stas.toDonat(mercedes, fiat, paz, zil);

        Mechanic<Car> mechanic1 = new Mechanic<>("Юрий Задов", "Золотой подшибник", "Легковые автомобили");
        mechanic1.serve(audi, bmw);
        Mechanic<Transport> mechanic2 = new Mechanic<>("Виктор Пускепалис", "ИП Оганисян", "Легковые, грузовые");
        mechanic2.serve(kia, hyundai, man, kamaz, belaz, scania);
        Mechanic<Bus> mechanic3 = new Mechanic<>("Джамулутдин Степанов", "Русский сервис", "Автобусы");
        mechanic3.serve(mercedes, fiat, paz, zil);
        Mechanic<Transport> mechanic4 = new Mechanic<>("Гус Хиддинг", "СТО№1", "Все виды");
        mechanic4.serve(audi, man, scania, mercedes);

        audi.printPersonalData();

        Station<Transport> sto = new Station<>();
        sto.addToQueue(audi);
        sto.addToQueue(bmw);
        sto.addToQueue(mercedes);
        sto.addToQueue(man);
        sto.doMaintenance();
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
            try {
                transport.checkTest();
            } catch (WrongTestDriveException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}