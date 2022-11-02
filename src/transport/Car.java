package transport;

public class Car extends Transport implements Competing {

    public static int counter = 0;


    public Car(String brand, String model, double engineVolume, Circles circles) {
        super(brand, model, engineVolume, circles);
        counter++;
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
    public String pitStop() {
        return getBrand() + " " + getModel() + " заехал на пит-стоп";
    }

    @Override
    public String maxSpeed() {
        int max = Integer.MIN_VALUE;
        int [] arr = getCircles().getSpeed();
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