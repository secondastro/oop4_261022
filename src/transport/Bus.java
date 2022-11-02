package transport;

public class Bus extends Transport implements Competing {
    public Bus(String brand, String model, double engineVolume, Circles circles) {
        super(brand, model, engineVolume, circles);
    }

    @Override
    public void start() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void finish() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " закончил движение");
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
        return "Максимальная скорость автобуса " + getBrand() + " " + getModel() + ": " + max + " км/ч";


    }

    public String BestTime() {
        double[] arr = getCircles().getTimes();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return "Автобус " + getBrand() + " " + getModel() + ". Лучшее время круга: " + min + " секунд";
    }
}
