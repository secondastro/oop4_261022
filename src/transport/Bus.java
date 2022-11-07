package transport;

public class Bus extends Transport implements Competing {

    public enum PassCapacity{XS(0,10),
        S(10,25),
        M(40,50),
        L(60,80),
        XL(100,120);
    private final int capacityMin;
    private final int capacityMax;

        PassCapacity(int capacityMin, int capacityMax) {
            this.capacityMin = capacityMin;
            this.capacityMax = capacityMax;
        }

        public int getCapacityMin() {
            return capacityMin;
        }

        public int getCapacityMax() {
            return capacityMax;
        }

        @Override
        public String toString() {
            return "вместимость: от " + getCapacityMin() + " до " + getCapacityMax() + " человек";
        }
    }

    private final PassCapacity passCapacity;
    public Bus(String brand, String model, double engineVolume, Circles circles, PassCapacity passCapacity) {
        super(brand, model, engineVolume, circles);
        this.passCapacity = passCapacity;
    }

    @Override
    public void printType() {
        if (this.passCapacity != null) {
            System.out.println(this.passCapacity);
        }else {
            System.out.println("Информации недостаточно");
        }

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
