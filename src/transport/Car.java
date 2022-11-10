package transport;

public class Car extends Transport implements Competing {
    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хэтчбэк"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        OUTLANDER("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        FURGON("Фургон"),
        MINIVAN("Минивен");
        private final String name;

        BodyType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "тип кузова: " +
                    this.name;
        }
    }

    public static int counter = 0;
    private final BodyType bodyType;

    public Car(String brand, String model, double engineVolume, Circles circles, BodyType bodyType) {
        super(brand, model, engineVolume, circles);
        this.bodyType = bodyType;
        counter++;
    }


    @Override
    public void printType() {
        if (this.bodyType != null)
            System.out.println(this.bodyType);
        else {
            System.out.println("Информации не достаточно");
        }
    }

    @Override
    public void start() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void finish() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " закончил движение");
    }

    @Override
    public void checkTest() throws WrongTestDriveException {
        s = null;
        for (Transport testedTransport : testedTransports) {
            if (this == testedTransport) {
                System.out.println(s = this.getBrand() + " " + this.getModel() + " прошел диагностику");
            }
        }
        if (s == null) {
            throw new WrongTestDriveException("!!!Автомобиль " + getBrand() + " " + getModel() + " не прошел диагностику!!!");
        }
    }


    @Override
    public String pitStop() {
        return getBrand() + " " + getModel() + " заехал на пит-стоп";
    }

    @Override
    public String maxSpeed() {
        int max = Integer.MIN_VALUE;
        int[] arr = getCircles().getSpeed();
        for (int anInt : arr) {
            if (anInt > max) {
                max = anInt;
            }
        }
        return "Максимальная скорость автомобиля " + getBrand() + " " + getModel() + ": " + max + " км/ч";


    }

    public String BestTime() {
        double[] arr = getCircles().getTimes();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return "Автомобиль " + getBrand() + " " + getModel() + ". Лучшее время круга: " + min + " секунд";
    }

}