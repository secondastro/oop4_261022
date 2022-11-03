import transport.*;

public class Main {
    public static void main(String[] args) {
        Car audi = new Car("Audi",
                "A8 50 L TDI quattro",
                3.0,
                new Transport.Circles(new double[]{124.55, 126.76, 110.0}, new int[]{190, 188, 192}));
        Car bmw = new Car("BMW",
                "Z8",
                3.0,
                new Transport.Circles(new double[]{114.65, 113.44, 112.45}, new int[]{210, 242, 251}));
        Car kia = new Car("Kia",
                "Sportage 4-го поколения",
                2.4,
                new Transport.Circles(new double[]{143.56, 155.55, 151.31}, new int[]{190, 200, 210}));
        Car hyundai = new Car("Hyundai",
                "Avante",
                1.6,
                new Transport.Circles(new double[]{144.44, 142.22, 134.44}, new int[]{200, 220, 215}));

        bmw.start();
        System.out.println(bmw.BestTime());
        System.out.println(bmw.pitStop());
        System.out.println(bmw.maxSpeed());
        bmw.finish();
        System.out.println();

        Bus mercedes = new Bus("Mercedes",
                "Sprinter",
                2.0,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}));
        Bus paz = new Bus("ПАЗ",
                "001",
                3.0,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}));
        Bus fiat = new Bus("Fiat",
                "Buss",
                2.5,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}));
        Bus zil = new Bus("ЗИЛ",
                "АП43",
                1.9,
                new Transport.Circles(new double[]{211.44, 213.44, 215.11}, new int[]{191, 190, 189}));

        mercedes.start();
        System.out.println(mercedes.BestTime());
        System.out.println(mercedes.pitStop());
        System.out.println(mercedes.maxSpeed());
        mercedes.finish();
        System.out.println();

        Truck man = new Truck("MAN",
                "Expeditor",
                8.5,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}));
        Truck kamaz = new Truck("КАМАЗ",
                "Комфорт",
                7.9,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}));
        Truck scania = new Truck("Scania",
                "Future",
                9.0,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}));
        Truck belaz = new Truck("Белаз",
                "Винтер",
                9.6,
                new Transport.Circles(new double[]{311.44, 313.10, 310.19}, new int[]{176, 177, 189}));

        kamaz.start();
        System.out.println(kamaz.BestTime());
        System.out.println(kamaz.pitStop());
        System.out.println(kamaz.maxSpeed());
        kamaz.finish();

        DriverB <Car> aleks = new DriverB<>("Александр Варачев", 1999);
        aleks.start(fiat);
        DriverC <Bus> max = new DriverC<>("Макс Трайбер", 2010);
        max.start(bmw);
        DriverD <Truck> vasilich = new DriverD<>("Василич", 1985);
        vasilich.start(hyundai);
        max.stop();

        System.out.println(vasilich.getLicenseType());





    }
}